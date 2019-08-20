package com.fanle.moka.controller;

import com.fanle.moka.constant.ActivityEnum;
import com.fanle.moka.constant.DataBaseConstant;
import com.fanle.moka.constant.base.BaseEnum;
import com.fanle.moka.respo.stat.MokaStatLogReportRespo;
import com.fanle.moka.service.BaseService;
import com.fanle.moka.service.ExportExcelService;
import com.fanle.moka.service.NativeQueryBaseService;
import com.fanle.moka.utils.StringTransferUtil;
import com.fanle.moka.vo.DataPv;
import com.fanle.moka.vo.DataUv;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moka/activity/all")
@Slf4j
public class ActivityAllDataController {

    @Autowired
    BaseService baseService;

    @Autowired
    NativeQueryBaseService nativeQueryBaseService ;

    @Autowired
    ExportExcelService exportExcelService ;

    @PersistenceContext
    EntityManager em ;

    @Autowired
    MokaStatLogReportRespo mokaStatLogReportRespo ;

    /**
     * #活动UV
     * @param startDate
     * @param endDate
     * @param response
     * @param type   all/out/in  总/站外/站内
     */
    @RequestMapping("/uv")
    public void appUv(@RequestParam("startDate")String startDate,
                        @RequestParam("endDate")String endDate,
                        @RequestParam("type")String type,
                        HttpServletResponse response){
        Set<String> keys = BaseEnum.keyValues(ActivityEnum.values());
        String condition  ;
        String filename = "" ;
        switch (type){
            case "all":
                condition = "\tAND 1=1\n";
                filename = "活动总uv(用户)";
                break;
            case "out":
                condition = "\tAND browser  in (  'wb','wx' ,'qq')\n";
                filename = "活动站外uv(用户)";
                break;
            case "in":
                condition = "\tAND browser not  in (  'wb','wx' ,'qq')\n";
                filename = "活动站内uv(用户)";
                break;
            default:
                condition  = "";
                break;
        }
        if (StringUtils.isEmpty(condition)) {
            return ;
        }
        String sql = "SELECT\n" +
                "\t  date_format(date,'%Y-%m-%d') date,\n" +
                "\tcount( DISTINCT unionid ) uv \n" +
                "FROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "WHERE\n" +
                "\t(`event` = 'activityPV' or `event` = 'acitivityPV') \n" +
                "\tAND\n" +
                "\tdate >= ?1 \n" +
                "\tAND\n" +
                "\tdate <= ?2 \n" +
                "\tAND\n" +
                "\taid IN \n" +BaseService.collectionToString(keys)+"\n"+
                condition+
                "\tGROUP BY\n" +
                "\tdate";
        filename+=".xlsx";
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        List<DataUv> list = nativeQueryBaseService.nativeQuery(sql,DataUv.class,startDate,endDate);
        exportExcelService.export(filename,response,null,list);
        //baseService.export(filename,null,response,sql, DataUv.class,startDate,endDate);
    }

    /**
     * 活动总PV
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/pv")
    public void outUv(@RequestParam("startDate")String startDate,
                        @RequestParam("endDate")String endDate,
                        HttpServletResponse response){
        Set<String> keys = BaseEnum.keyValues(ActivityEnum.values());
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String sql = "SELECT\n" +
                "\t date_format(date,'%Y-%m-%d') date,\n" +
                "\tcount( * ) pv\n" +
                "FROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "WHERE\n" +
                "\t(`event` = 'activityPV' or `event` = 'acitivityPV') \n" +
                "\tAND\n" +
                "\tdate >= ?1 \n" +
                "\tAND\n" +
                "\tdate <= ?2 \n" +
                "\tAND\n" +
                "\taid IN \n" +BaseService.collectionToString(keys)+"\n"+
                "\tGROUP BY\n" +
                "\tdate";
        String filename = "活动总pv" ;
        filename+=".xlsx";
        List<DataPv> list = nativeQueryBaseService.nativeQuery(sql, DataPv.class,startDate,endDate);
        exportExcelService.export(filename,response,null,list);
        //baseService.export(filename,null,response,sql, DataPv.class,startDate,endDate);
    }

    /**
     * 活动总激活uv（设备号去重）
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/active")
    public void active(@RequestParam("startDate")String startDate,
                        @RequestParam("endDate")String endDate,
                        HttpServletResponse response){
        Set<String> keys = BaseEnum.keyValues(ActivityEnum.values());
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String sql = "SELECT\n" +
                "\tSUBSTR( firstStartTime, 1, 10 ) date,\n" +
                "\tcount( sDeviceId ) uv\n" +
                "FROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_appstart \n" +
                "WHERE\n" +
                "\tfirstStartTime >= ?1\n" +
                "\tAND\n" +
                "\tfirstStartTime <= ?2\n" +
                "\tAND\n" +
                "\taid IN \n" +BaseService.collectionToString(keys)+"\n"+
                "GROUP BY\n" +
                "SUBSTR( firstStartTime, 1, 10 )";
        String filename = "活动总激活uv(设备)" ;
        filename+=".xlsx";
        List<DataUv> list = nativeQueryBaseService.nativeQuery(sql,DataUv.class,startDate,endDate);
        exportExcelService.export(filename,response,null,list);
    }

    @RequestMapping("/appStartKeepd")
    public String keep(String date,int day,String aid){
        LocalDate localDate = LocalDate.parse(date);
        localDate.plusDays(day);
        String sql = "select distinct sDeviceId from moka_stat_appstart where firstStartTime like '" + date + "' "+"and aid = '"+aid+"' ";
        List<Object[]> deviceIds =  this.em.createNativeQuery(sql).getResultList() ;
        List<String> deviceList = Lists.newArrayList() ;
        log.info("all-count={}",deviceIds.size());
        if(CollectionUtils.isNotEmpty(deviceIds)){
           deviceList = deviceIds.stream().map(x -> x[0].toString()).collect(Collectors.toList());
        }
        long count = mokaStatLogReportRespo.countDistinctByDateAndEventAndDeviceIdInAndAid(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE),"launch",deviceList,aid);
        log.info("count={}",count);
        if(CollectionUtils.isEmpty(deviceList)){
            return "0" ;
        }else{
            return BigDecimal.valueOf(count).divide(BigDecimal.valueOf(deviceList.size(),2)).toString() ;
        }
    }
}
