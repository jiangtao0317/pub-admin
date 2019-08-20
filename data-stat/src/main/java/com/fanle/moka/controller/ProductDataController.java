package com.fanle.moka.controller;

import com.fanle.moka.constant.DataBaseConstant;
import com.fanle.moka.constant.ReadPathEnum;
import com.fanle.moka.constant.SystemConstant;
import com.fanle.moka.constant.base.BaseEnum;
import com.fanle.moka.service.*;
import com.fanle.moka.utils.StringTransferUtil;
import com.fanle.moka.vo.DataUv;
import com.fanle.moka.vo.ProductAllDataVo;
import com.fanle.moka.vo.ProductReadPathFormatVo;
import com.fanle.moka.vo.ReadPath;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/moka/product")
@Slf4j
public class ProductDataController {

    @Autowired
    TopBaseService baseService ;

//    @Autowired
//    BookRespo bookRespo ;
    @Autowired
NativeQueryBaseService nativeQueryBaseService ;

    @Autowired
    ExportExcelService exportExcelService ;

    @RequestMapping(value = "demo",method = RequestMethod.GET)
    public Map<String,String> map(){
        //bookRespo.findFirstBySeqid(1001L);
        Map<String,String> map = Maps.newHashMap();
        map.put("hello","world");
        return map ;
    }



    @RequestMapping("/all-data")
    public void allData(@RequestParam("startDate")String startDate,
                        @RequestParam("endDate")String endDate,HttpServletResponse response,
                        @RequestParam(name = "version",defaultValue = "all") Set<String> versions,
                        @RequestParam(name = "cid",defaultValue = "all")Set<String> cids){
        Set<String> all = Sets.newHashSet() ;
        all.add(SystemConstant.ALL);
        String conditionCid = "\tand cid in ?3\n";
        if(cids.contains(SystemConstant.ALL)){
            cids = all ;
        }
        String conditionVersion = "\tand version in ?4 \n";
        if(versions.contains(SystemConstant.ALL)){
            versions = all ;
        }
        String sql = "SELECT\n" +
                "\ta.date date,\n" +
                "\tsum(a.shareAppPv) shareAppPvSum,\n" +
                "\tsum(a.shareAppUv) shareAppUvSum,\n" +
                "\tsum(a.readSec) readSecSum ,\n" +
                "\tsum(a.readUserUv) readUserSum,\n" +
                "\tsum(a.onlineSec) onlineSum,\n" +
                "\tsum(a.bookUv) bookUvSum,\n" +
                "\tsum(a.loginAppStartPv) loginAppStartPvSum,\n" +
                "\tsum(a.login-a.loginGuest) accountLoginSum,\n" +
                "\tsum(a.loginGuest) loginGuestSum\n" +
                "\tfrom "+ DataBaseConstant.WENXUE_STAT +".moka_stat_day a where a.date >= ?1 and a.date <= ?2\n" +
                "\tand platform ='app'\n" +
                conditionCid+conditionVersion+" "+
                "\tgroup by a.date";

        String conditionCid1 = "\tAND 1=1\n";
        int index = 3 ;
        if(!cids.contains(SystemConstant.ALL)){
            index = 4 ;
            conditionCid1 = "\tand cid in ?3\n";
        }
        String conditionVersion1 = "\tand 1=1\n";
        if(!versions.contains(SystemConstant.ALL)){
            if(index==3){
                conditionVersion1 = "\tand version in ?3\n";
            } else{
                conditionVersion1 = "\tand version in ?4 \n";
            }
        }

        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String sql2 = "SELECT SUBSTR( a.firstStartTime, 1, 10 ) date , count(  DISTINCT a.sDeviceId ) uv \n" +
                "FROM "+ DataBaseConstant.WENXUE_STAT +".moka_stat_appstart a \n" +
                "WHERE \n" +
                "\ta.firstStartTime >= ?1 \n" +
                "AND \n" +
                "\ta.firstStartTime <= ?2 \n" +
                "AND \n" +
                "\ta.platform IN ( 'android', 'ios' ) \n" +
                conditionCid1+conditionVersion1+" "+
                "GROUP BY\n" +
                "\tSUBSTR( a.firstStartTime, 1, 10 )";
//        baseService.export("产品数据-整体数据-cid="+cid+"-version="+version+".xlsx", null
//        , response,sql,ProductAllDataVo.class,startDate,endDate,version);
        List<ProductAllDataVo> list = nativeQueryBaseService.nativeQuery(sql,ProductAllDataVo.class,startDate,endDate,cids,versions);
        cids = cids.contains(SystemConstant.ALL)?null:cids ;
        versions = versions.contains(SystemConstant.ALL)?null:versions ;
        List<DataUv> list2 = nativeQueryBaseService.nativeQuery(sql2,DataUv.class,startDate,endDate,cids,versions);
        list.forEach(x -> {
            list2.forEach(y -> {
                if(StringUtils.equals(x.getDate(),y.getDate())){
                    x.setAddAppStart(y.getUv());
                }
            });
        });
        exportExcelService.export("产品数据-整体数据.xlsx",response,null,list);
    }

    /**
     * 当天设备启动UV
     * @param startDate
     * @param endDate
     * @param response
     */
//    @RequestMapping("/day-appstart-uv")
//    public void appstart(@RequestParam("startDate")String startDate,
//                        @RequestParam("endDate")String endDate,HttpServletResponse response){
//
//        String sql = "SELECT\n" +
//                "\tSUBSTR(a.dateTime,1,10) date,\n" +
//                "\tcount( DISTINCT a.deviceId ) uv \n" +
//                "FROM\n " +
//                DataBaseConstant.WENXUE_STAT +".moka_stat_appstart_history a \n" +
//                "WHERE\n" +
//                "\ta.dateTime >= '"+startDate+"' \n" +
//                "\tAnd a.dateTime <= '"+endDate+"' \n" +
//                "\tAND a.platform IN ( 'android', 'ios' )\n" +
//                "Group by SUBSTR(a.dateTime,1,10)";
//
//        baseService.export("app设备启动UV.xlsx",response,sql, DataUv.class);
//    }

    /**
     * 新增启动uv
     * @param startDate
     * @param endDate
     * @param response
     */
//    @RequestMapping("/day-add-appstart")
//    public void addAppStart(@RequestParam("startDate")String startDate,
//                            @RequestParam("endDate")String endDate,HttpServletResponse response,
//                            @RequestParam(name = "version",defaultValue = SystemConstant.ALL)String version,
//                            @RequestParam(name = "cid",defaultValue = "all")String cid){
//        String condition = "\tAND 1=1\n";
//        if(!StringUtils.equalsIgnoreCase(SystemConstant.ALL,version)){
//            condition = "\tAND a.version = '" +version+"'\n";
//        }
//        if(!StringUtils.equalsIgnoreCase(SystemConstant.ALL,cid)){
//            condition += "\tAND a.cid = '" +cid+"'\n";
//        }
//        String sql = "SELECT SUBSTR( a.firstStartTime, 1, 10 ) date , count( * ) uv \n" +
//                "FROM "+ DataBaseConstant.WENXUE_STAT +".moka_stat_appstart a \n" +
//                "WHERE \n" +
//                "\ta.firstStartTime >= ?1 \n" +
//                "AND \n" +
//                "\ta.firstStartTime <= ?2 \n" +
//                "AND \n" +
//                "\ta.platform IN ( 'android', 'ios' ) \n" +
//                condition+
//                "GROUP BY\n" +
//                "\tSUBSTR( a.firstStartTime, 1, 10 )";
//
//       // baseService.export("新增启动uv.xlsx",null,response,sql, DataUv.class,startDate,endDate);
//        List list = nativeQueryBaseService.nativeQuery(sql,DataUv.class,startDate,endDate);
//        exportExcelService.export("新增启动uv.xlsx",response,null,list);
//    }

    /**
     * 阅读路径PV / UV
     * @param startDate
     * @param endDate
     * @param type  pv/uv
     * @param response
     */
    @RequestMapping("/day-read-path")
    public void readPath(@RequestParam("startDate")String startDate,
                         @RequestParam("endDate")String endDate,
                         @RequestParam("type")String type,
                         @RequestParam(name = "version",defaultValue = "all") Set<String> versions,
                         @RequestParam(name = "cid",defaultValue = "all")Set<String> cids,
                         HttpServletResponse response){
        String dis = "count(*) ";
        if(StringUtils.equalsIgnoreCase("uv",type)){
            dis = "count(distinct a.userid) `value` ";
        }
        if(StringUtils.equalsIgnoreCase("pv",type)){
            dis += "`value` ";
        }
//        String conditionCid = "\tand 1=1\n";
//        if(!cids.contains(SystemConstant.ALL)){
//            conditionCid = "\tand cid in ?3\n";
//        }
//        String conditionVersion = "\tand 1=1\n";
//        if(!versions.contains(SystemConstant.ALL)){
//            conditionVersion = "\tand version in ?4 \n";
//        }
        String conditionCid = "\tAND 1=1\n";
        int index = 3 ;
        if(!cids.contains(SystemConstant.ALL)){
            index = 4 ;
            conditionCid = "\tand cid in ?3\n";
        }
        String conditionVersion = "\tand 1=1\n";
        if(!versions.contains(SystemConstant.ALL)){
            if(index==3){
                conditionVersion = "\tand version in ?3\n";
            } else{
                conditionVersion = "\tand version in ?4 \n";
            }
        }
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String sql = "SELECT\n" +
                "\t"+dis+",\n" +
                " \tcase a.`event`\n" ;
        sql = BaseService.getCaseWhen(sql, ReadPathEnum.values());
        String endSql =  " end path,\n" +
                "\tSUBSTR( a.datetime, 1, 10 ) date \n" +
                "\tFROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report a \n" +
                "\tWHERE\n" +
                "\ta.datetime >= ?1 \n" +
                "\tAND a.datetime <= ?2 \n" +
                "\tand a.`event` in "+BaseService.collectionToString(BaseEnum.keyValues(ReadPathEnum.values()))+
                "\t and platform in ('android','ios') \n" +
                conditionCid+conditionVersion+
                "\t GROUP BY\n" +
                "\ta.`event`,\n" +
                "\tSUBSTR( a.datetime, 1, 10 ) \n" +
                "\tORDER BY\n" +
                "\tSUBSTR( a.datetime, 1, 10 ) ASC;";
        sql += endSql ;
        System.out.println(sql);
        ListContentFormatService<ReadPath, ProductReadPathFormatVo> format =  (List<ReadPath> sourceList, List<ProductReadPathFormatVo> targetList) -> {
            Map<String,ProductReadPathFormatVo> maps = Maps.newHashMap() ;
            sourceList.forEach(source -> {
                ProductReadPathFormatVo target = getProductReadPathFormatVo(maps, source.getDate());
                target.setDate(source.getDate());
                for(String name: BaseEnum.nameValues(ReadPathEnum.values())){
                    String key = BaseEnum.getKey(name,ReadPathEnum.values());
                    key = StringTransferUtil.toUpperCaseFirstOne(key);
                    String method = "set"+key ;
                    if(name.equals(source.getPath())){
                        try {
                            target.getClass().getMethod(method,long.class).invoke(target,source.getValue());
                        } catch (Exception e) {
                            log.info("反射调用方法:{}失败",e);
                        }
                    }
                }
                if(!maps.keySet().contains(source.getDate())){
                    maps.put(source.getDate(),target);
                    targetList.add(target);
                }
            });
            return targetList ;
        } ;
        String  filename = "阅读路径"+type+".xlsx" ;
        cids = cids.contains(SystemConstant.ALL)?null:cids ;
        versions = versions.contains(SystemConstant.ALL)?null:versions ;
        List list = nativeQueryBaseService.nativeQuery(sql,ReadPath.class,startDate,endDate,cids,versions);
        exportExcelService.export(filename,response,format,list);
    }

    private ProductReadPathFormatVo getProductReadPathFormatVo(Map<String, ProductReadPathFormatVo> maps, String date) {
        ProductReadPathFormatVo target = maps.get(date);
        if (!maps.keySet().contains(date)) {
            target = new ProductReadPathFormatVo();
        }
        return target;
    }

}
