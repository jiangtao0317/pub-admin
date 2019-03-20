package com.fanle.moka.controller;

import com.fanle.moka.constant.ActivityEnum;
import com.fanle.moka.constant.DataBaseConstant;
import com.fanle.moka.constant.base.BaseEnum;
import com.fanle.moka.service.BaseService;
import com.fanle.moka.vo.ActivityDataPv;
import com.fanle.moka.vo.ActivityDataUv;
import com.fanle.moka.vo.DataUv;
import com.fanle.moka.vo.MkStoreVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RestController
@RequestMapping("/moka/activity/single")
@Slf4j
public class ActivitySingleDataController {

    @Autowired
    BaseService baseService ;

    /**
     * #1.活动站内UV(用户)
     * @param startDate
     * @param endDate
     * * @param type   all/out/in  总/站外/站内
     * @param response
     */
    @RequestMapping("uv")
    public void appUv(@RequestParam("startDate")String startDate,
                      @RequestParam("endDate")String endDate,
                      @RequestParam(name="type",defaultValue = "all")String type,
                      HttpServletResponse response){
        String condition  ;
        String filename = "" ;
        switch (type){
            case "all":
                condition = "\tAND 1=1\n";
                filename = "单个活动累计uv(用户)";
                break;
            case "out":
                condition = "\tAND browser not in ('androidApp','iosApp')\n";
                filename = "单个活动站外uv(用户)";
                break;
            case "in":
                condition = "\tAND browser  in ('androidApp','iosApp' )\n";
                filename = "单个活动站内uv(用户)";
                break;
            default:
                condition  = "";
                break;
        }
        if (StringUtils.isEmpty(condition)) {
            return ;
        }
        Set<String> keys = BaseEnum.keyValues(ActivityEnum.values());
        keys.remove(ActivityEnum.MKSTORE_REDBAG.getKey()); //小程序拆红包活动只有站外 ，uv单算
        startDate += " 00:00:00";
        endDate += " 23:59:59";
        String sql = "SELECT\n" +
                "\tcase aid \n" ;
        sql = BaseService.getCaseWhen(sql, ActivityEnum.values());
        String endSql = "\tend activity,\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                "\tcount( DISTINCT unionid ) uv\n" +
                "FROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "WHERE\n" +
                "\tdatetime >= ?1\n" +
                "\tAND\n" +
                "\tdatetime <= ?2\n" +
                "\tAND\n" +
                "\t(`event` = 'activityPV' or `event` = 'acitivityPV')\n" +
                "\tAND aid IN \n" +BaseService.collectionToString(keys)+
                condition+
                "GROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 ),\n" +
                "\taid";
        sql += endSql ;
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, ActivityDataUv.class,startDate,endDate);
    }


    /**
     * 小程序累计UV（小程序拆红包只有站外）
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/mkstore-redbag/uv")
    public void mkstore(@RequestParam("startDate")String startDate,
                      @RequestParam("endDate")String endDate,
                      HttpServletResponse response){
        String filename = "小程序拆红包uv";
        startDate += " 00:00:00";
        endDate += " 23:59:59";
        String sql = "SELECT\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                "\tcount( DISTINCT userid ) uv \n" +
                "\tFROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "\tWHERE\n" +
                "\tdatetime >= ?1\n" +
                "\tAND\n" +
                "\tdatetime <= ?2\n" +
                "\tAND\n" +
                "\t(`event` = 'activityPV' or `event` = 'acitivityPV')\n" +
                "\tAND aid = '"+ActivityEnum.MKSTORE_REDBAG+"'\n" +
                "\tGROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 ),aid\n" +
                "\tORDER BY aid asc ,SUBSTR( datetime, 1, 10 ) asc\n";
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, DataUv.class,startDate,endDate);
    }


    /**
     * 活动PV(包括小程序)
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/pv")
    public void pv(@RequestParam("startDate")String startDate,
                      @RequestParam("endDate")String endDate,
                      HttpServletResponse response){
        startDate += " 00:00:00";
        endDate += " 23:59:59";
        Set<String> keys = BaseEnum.keyValues(ActivityEnum.values());
        String sql = "SELECT\n" +
                "\tcase aid \n" ;
        sql = BaseService.getCaseWhen(sql, ActivityEnum.values());
        String endSql = "\tend activity,\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                "\tcount( * ) pv\n" +
                "\tFROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "\tWHERE\n" +
                "\tdatetime >= ?1\n" +
                "\tAND\n" +
                "\tdatetime <= ?2\n" +
                "\tAND\n" +
                "\t(`event` = 'activityPV' or `event` = 'acitivityPV')\n" +
                "\tAND aid IN  \n" +BaseService.collectionToString(keys)+
                "\tGROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 ),aid";
        sql += endSql ;
        String filename = "单个活动累计pv" ;
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, ActivityDataPv.class,startDate,endDate);
    }

    /**
     * 单个活动激活uv(设备)
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
                "\tcase aid \n" ;
        sql = BaseService.getCaseWhen(sql, ActivityEnum.values());
        String endSql = "\tend activity,\n" +
                "\tSUBSTR( firstStartTime, 1, 10 ) date,\n" +
                "\tcount( DISTINCT sDeviceId ) uv \n" +
                "\tFROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_appstart \n" +
                "\tWHERE\n" +
                "\tfirstStartTime >= ?1\n" +
                "\tAND\n" +
                "\tfirstStartTime <= ?2\n" +
                "\tAND\n" +
                "\taid IN \n" +BaseService.collectionToString(keys)+
                "\tGROUP BY\n" +
                "\tSUBSTR( firstStartTime, 1, 10 ),\n" +
                "\taid\n";
        sql += endSql ;
        String filename = "单个活动激活uv(设备)" ;
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, ActivityDataUv.class,startDate,endDate);
    }


    /**
     * 小程序拆红包 来源UV(设备去重)
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/mkstore")
    public void mkst(@RequestParam("startDate")String startDate,
                       @RequestParam("endDate")String endDate,
                       HttpServletResponse response){
        startDate += " 00:00:00";
        endDate += " 23:59:59";
        String sql = "SELECT\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                "CASE\n" +
                "\t\text0 \n" +
                "\t\tWHEN '1007' THEN\n" +
                "\t\t'红包页面' \n" +
                "\t\tWHEN '1008' THEN\n" +
                "\t\t'红包页面' \n" +
                "\t\tWHEN '1036' THEN\n" +
                "\t\t'APP分享卡片' \n" +
                "\t\tWHEN '1011' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1012' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1013' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1025' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1031' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1032' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1047' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1048' THEN\n" +
                "\t\t'扫码' \n" +
                "\t\tWHEN '1049' THEN\n" +
                "\t\t'扫码' ELSE '书店' \n" +
                "\tEND source,\n" +
                "\tcount( DISTINCT deviceId ) uv \n" +
                "FROM\n" +
                "\t"+ DataBaseConstant.WENXUE_STAT +".moka_stat_log_report \n" +
                "WHERE\n" +
                "\t( `event` = 'activityPV' OR `event` = 'acitivityPV' ) \n" +
                "\tAND aid = '"+ActivityEnum.MKSTORE_REDBAG+"' \n" +
                "\tAND datetime >= ?1 \n" +
                "\tAND datetime <= ?2 \n" +
                "GROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 ),\n" +
                "\tsource";
        String filename = "小程序拆红包";
        log.info("{}:sql===={}",filename,sql);
        filename+=".xlsx";
        baseService.export(filename,null,response,sql, MkStoreVo.class,startDate,endDate);
    }


}
