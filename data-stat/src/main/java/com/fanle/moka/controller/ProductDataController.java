package com.fanle.moka.controller;

import com.fanle.moka.constant.DataBaseConstant;
import com.fanle.moka.constant.ReadPathEnum;
import com.fanle.moka.constant.SystemConstant;
import com.fanle.moka.constant.base.BaseEnum;
import com.fanle.moka.respo.BookRespo;
import com.fanle.moka.service.BaseService;
import com.fanle.moka.service.ListContentFormatService;
import com.fanle.moka.service.TopBaseService;
import com.fanle.moka.utils.StringTransferUtil;
import com.fanle.moka.vo.*;
import com.google.common.collect.Maps;
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

@RestController
@RequestMapping("/moka/product")
@Slf4j
public class ProductDataController {

    @Autowired
    TopBaseService baseService ;

    @Autowired
    BookRespo bookRespo ;

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
                        @RequestParam(name = "version",defaultValue = "all")String version,
                        @RequestParam(name = "cid",defaultValue = "all")String cid){

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
                "from "+ DataBaseConstant.WENXUE_STAT +".moka_stat_day a where a.date >= ?1 and a.date <= ?2\n" +
                "and cid = 'all' and platform in ('android','ios') and version = ?3\n" +
                "group by a.date";
        baseService.export("产品数据-整体数据-cid="+cid+"-version"+version+".xlsx", null
        , response,sql,ProductAllDataVo.class,startDate,endDate,version);
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
    @RequestMapping("/day-add-appstart")
    public void addAppStart(@RequestParam("startDate")String startDate,
                            @RequestParam("endDate")String endDate,HttpServletResponse response,
                            @RequestParam(name = "version",defaultValue = SystemConstant.ALL)String version){
        String condition = "\tAND 1=1\n";
        if(!StringUtils.equalsIgnoreCase(SystemConstant.ALL,version)){
            condition = "\tAND a.version = '" +version+"'\n";
        }
        String sql = "SELECT SUBSTR( a.firstStartTime, 1, 10 ) date , count( * ) uv \n" +
                "FROM "+ DataBaseConstant.WENXUE_STAT +".moka_stat_appstart a \n" +
                "WHERE \n" +
                "\ta.firstStartTime >= ?1 \n" +
                "AND \n" +
                "\ta.firstStartTime <= ?2 \n" +
                "AND \n" +
                "\ta.platform IN ( 'android', 'ios' ) \n" +
                condition+
                "GROUP BY\n" +
                "\tSUBSTR( a.firstStartTime, 1, 10 )";

        baseService.export("新增启动uv.xlsx",null,response,sql, DataUv.class,startDate,endDate);
    }

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
                         HttpServletResponse response){
        String dis = "count(*) ";
        Class c = ReadPathUv.class ;
        if(StringUtils.equalsIgnoreCase("uv",type)){
            dis = "count(distinct a.userid) "+type;
            c = ReadPathUv.class;
        }
        if(StringUtils.equalsIgnoreCase("pv",type)){
            c = ReadPathPv.class ;
            dis += type;
        }
        startDate += " 00:00:00";
        endDate += " 23:59:59";
        String sql = "SELECT\n" +
                "\t"+dis+",\n" +
                " \tcase a.`event`\n" ;
        sql = BaseService.getCaseWhen(sql,ReadPathEnum.values());
        String endSql =  " end path,\n" +
                "\tSUBSTR( a.datetime, 1, 10 ) date \n" +
                "\tFROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report a \n" +
                "\tWHERE\n" +
                "\ta.datetime >= ?1 \n" +
                "\tAND a.datetime <= ?2 \n" +
                "\tand a.`event` in "+BaseService.collectionToString(BaseEnum.keyValues(ReadPathEnum.values()))+
                "\t GROUP BY\n" +
                "\ta.`event`,\n" +
                "\tSUBSTR( a.datetime, 1, 10 ) \n" +
                "\tORDER BY\n" +
                "\tSUBSTR( a.datetime, 1, 10 ) ASC;";
        sql += endSql ;
        System.out.println(sql);
        if("pv".equals(type)){
            ListContentFormatService<ReadPathPv,ProductReadPathFormatVo> format =  (List<ReadPathPv> sourceList, List<ProductReadPathFormatVo> targetList) -> {
                Map<String,ProductReadPathFormatVo> maps = Maps.newHashMap() ;
                sourceList.forEach(source -> {
                    ProductReadPathFormatVo target = maps.get(source.getDate());
                    if(!maps.keySet().contains(source.getDate())){
                        target = new ProductReadPathFormatVo() ;
                    }
                    target.setDate(source.getDate());
                    for(String name: BaseEnum.nameValues(ReadPathEnum.values())){
                        String key = BaseEnum.getKey(name,ReadPathEnum.values());
                        key = StringTransferUtil.toUpperCaseFirstOne(key);
                        String method = "set"+key ;
                        if(name.equals(source.getPath())){
                            try {
                                target.getClass().getMethod(method,long.class).invoke(target,source.getPv());
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
            baseService.export("阅读路径"+type+".xlsx",format,response,sql, c,startDate,endDate);
        }else{
            ListContentFormatService<ReadPathUv,ProductReadPathFormatVo> format =  (List<ReadPathUv> sourceList, List<ProductReadPathFormatVo> targetList) -> {
                Map<String,ProductReadPathFormatVo> maps = Maps.newHashMap() ;
                sourceList.forEach(source -> {
                    ProductReadPathFormatVo target = maps.get(source.getDate());
                    if (!maps.keySet().contains(source.getDate())) {
                        target = new ProductReadPathFormatVo();
                    }
                    target.setDate(source.getDate());
                    for (String name : BaseEnum.nameValues(ReadPathEnum.values())) {
                        String key = BaseEnum.getKey(name, ReadPathEnum.values());
                        key = StringTransferUtil.toUpperCaseFirstOne(key);
                        String method = "set" + key;
                        if (name.equals(source.getPath())) {
                            try {
                                target.getClass().getMethod(method, long.class).invoke(target, source.getUv());
                            } catch (Exception e) {
                                log.info("反射调用方法:{}失败", e);
                            }
                        }
                    }
                    if (!maps.keySet().contains(source.getDate())) {
                        maps.put(source.getDate(), target);
                        targetList.add(target);
                    }
                });
                return targetList;
            } ;
            baseService.export("阅读路径"+type+".xlsx",format,response,sql, c,startDate,endDate);
        }


    }

}
