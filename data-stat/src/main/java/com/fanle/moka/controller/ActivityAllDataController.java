package com.fanle.moka.controller;

import com.fanle.moka.constant.ActivityEnum;
import com.fanle.moka.constant.DataBaseConstant;
import com.fanle.moka.constant.base.BaseEnum;
import com.fanle.moka.service.BaseService;
import com.fanle.moka.vo.DataPv;
import com.fanle.moka.vo.DataUv;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RestController
@RequestMapping("/moka/activity/all")
@Slf4j
public class ActivityAllDataController {

    @Autowired
    BaseService baseService;

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
        startDate += " 00:00:00";
        endDate += " 23:59:59";
        String condition  ;
        String filename = "" ;
        switch (type){
            case "all":
                condition = "\tAND 1=1\n";
                filename = "活动总uv(用户)";
                break;
            case "out":
                condition = "\tAND browser not in (  'androidApp','iosApp' )\n";
                filename = "活动站外uv(用户)";
                break;
            case "in":
                condition = "\tAND browser  in (  'androidApp','iosApp' )\n";
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
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                "\tcount( DISTINCT userid ) uv \n" +
                "FROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "WHERE\n" +
                "\tdatetime >= ?1 \n" +
                "\tAND\n" +
                "\tdatetime <= ?2 \n" +
                "\tAND\n" +
                "\t(`event` = 'activityPV' or `event` = 'acitivityPV') \n" +
                "\tAND\n" +
                "\taid IN \n" +BaseService.collectionToString(keys)+"\n"+
                condition+
                "\tGROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 );";
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, DataUv.class,startDate,endDate);
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
        startDate += " 00:00:00";
        endDate += " 23:59:59";
        String sql = "SELECT\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                "\tcount( * ) pv\n" +
                "FROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "WHERE\n" +
                "\tdatetime >= ?1 \n" +
                "\tAND\n" +
                "\tdatetime <= ?2 \n" +
                "\tAND\n" +
                "\t(`event` = 'activityPV' or `event` = 'acitivityPV') \n" +
                "\tAND\n" +
                "\taid IN \n" +BaseService.collectionToString(keys)+"\n"+
                "\tGROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 )";
        String filename = "活动总pv" ;
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, DataPv.class,startDate,endDate);
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
        startDate += " 00:00:00";
        endDate += " 23:59:59";
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
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, DataUv.class,startDate,endDate);
    }
}
