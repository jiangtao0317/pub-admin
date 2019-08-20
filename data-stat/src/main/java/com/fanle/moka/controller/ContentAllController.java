package com.fanle.moka.controller;


import com.fanle.moka.service.BaseService;
import com.fanle.moka.service.ExportExcelService;
import com.fanle.moka.service.NativeQueryBaseService;
import com.fanle.moka.utils.StringTransferUtil;
import com.fanle.moka.vo.ContentUv;
import com.fanle.moka.constant.SystemConstant;
import com.fanle.moka.vo.ContentNumber;
import com.fanle.moka.vo.ContentPv;
import com.fanle.moka.vo.DataUv;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/moka/content/all")
@Slf4j
public class ContentAllController extends ContentController {

    @Autowired
    BaseService baseService ;

    @Autowired
    NativeQueryBaseService nativeQueryBaseService ;

    @Autowired
    ExportExcelService exportExcelService ;

    @RequestMapping("/in")
    public void in(@RequestParam("startDate")String startDate,
                   @RequestParam("endDate")String endDate,
                   @RequestParam(name="type",defaultValue = "pv")String type,
                   HttpServletResponse response){
        Class c = ContentPv.class ;
        String coutSql = "count(*) "+type+" ";
        if(StringUtils.equalsIgnoreCase(SystemConstant.UV,type)){
            c = ContentUv.class ;
            coutSql = "count(distinct a.userid) "+type+ " ";
        }
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "动态帖子站内阅读总"+type+".xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                coutSql +
                "FROM\n" +
                "\twenxue_statistics.moka_stat_log_report a , wenxue_dynamic.dynamic b\n" +
                "WHERE\n" +
                "\t( a.`event` = '/queryclubpostdetails' OR a.`event` = '/queryDynamicDetails' ) \n" +
                "\tand a.platform not in \n" +BaseService.collectionToString(out_browsers)+
                "\tand a.datetime >= ?1\n" +
                "\tand a.datetime <= ?2\n" +
                "\tAND a.ext0 = b.dynamicid And b.userid in\n" +BaseService.collectionToString(userids)+
                "GROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 )";
       // baseService.export(filename,null,response,sql, c,startDate,endDate);
        List list = nativeQueryBaseService.nativeQuery(sql,c,startDate,endDate);
        exportExcelService.export(filename,response,null,list);
    }

    @RequestMapping("/out")
    public void out(@RequestParam("startDate")String startDate,
                   @RequestParam("endDate")String endDate,
                   @RequestParam(name="type",defaultValue = "pv")String type,
                   HttpServletResponse response){
        Class c = ContentPv.class ;
        String coutSql = "count(*) "+type+" ";
        if(StringUtils.equalsIgnoreCase(SystemConstant.UV,type)){
            c = ContentUv.class ;
            coutSql = "count(distinct a.deviceId) "+type+ " ";
        }
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "动态帖子站外阅读总"+type+".xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                coutSql +
                "FROM\n" +
                "\twenxue_statistics.moka_stat_log_report a , wenxue_dynamic.dynamic b\n" +
                "WHERE\n" +
                "\t( a.`event` = 'liveMessagePV' OR a.`event` = 'clubPostPV' ) \n" +
                "\tand a.browser in \n" +BaseService.collectionToString(out_browsers)+
                "\tand a.datetime >= ?1\n" +
                "\tand a.datetime <= ?2\n" +
                "\tAND a.coid = b.dynamicid And b.userid in\n" +BaseService.collectionToString(userids)+
                "GROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 )";
        List list = nativeQueryBaseService.nativeQuery(sql,c,startDate,endDate);
        exportExcelService.export(filename,response,null,list);
    }



    /**
     * 动态帖子发表数量
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/number")
    public void number(@RequestParam("startDate")String startDate,
                       @RequestParam("endDate")String endDate,
                       HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "动态帖子总发表数量.xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( creatdate, 1, 10 ) as date,\n" +
                "\tCOUNT( dynamicid ) as number \n" +
                "FROM\n" +
                "\twenxue_dynamic.dynamic a \n" +
                "WHERE\n" +
                "\ta.creatdate >= ?1\n" +
                "\tand a.creatdate <= ?2\n" +
                "\tand a.userid in ?3 \n" +
                "\tand a.bigType in ('1','3')" +
                "GROUP BY\n" +
                "\tSUBSTR( creatdate, 1, 10 )\n" +
                "\tORDER BY SUBSTR( creatdate, 1, 10 ) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, ContentNumber.class, startDate, endDate,userids);
        exportExcelService.export(filename, response, null, list);
    }

    /**
     * user 动态帖子评论次数
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/comment-times")
    public void times(@RequestParam("startDate")String startDate,
                      @RequestParam("endDate")String endDate,
                      HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename =  "动态帖子总评论次数.xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( creatdate, 1, 10 ) as date,\n" +
                "\tsum(a.commenttimes) number\n" +
                "\tFROM\n" +
                "\twenxue_dynamic.dynamic a \n" +
                "\tWHERE\n" +
                "\ta.creatdate >= ?1\n" +
                "\tand a.creatdate <= ?2\n" +
                "\tand a.userid in ?3 \n"+
                "\tand a.bigType in ('1','3')\n" +
                "\tGROUP BY\n" +
                "\tSUBSTR( creatdate, 1, 10 )\n" +
                "\tORDER BY SUBSTR( creatdate, 1, 10 ) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, ContentNumber.class, startDate, endDate, userids);
        exportExcelService.export(filename, response, null, list);
    }



    /**
     * user 动态帖子站外阅读uv
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/total-out-uv")
    public void totalOutUv(@RequestParam("startDate")String startDate,
                      @RequestParam("endDate")String endDate,
                      HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename =  "站外动态帖子阅读uv.xlsx";
        String sql = "select substr(datetime,1,10) date , count(distinct unionid) uv from wenxue_statistics.moka_stat_log_report where datetime >= " +
                " ?1 and datetime <= ?2 and `event` in ('liveMessagePV','clubPostPV')  group by substr(datetime,1,10) order by substr(datetime,1,10) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, DataUv.class, startDate, endDate);
        exportExcelService.export(filename, response, null, list);
    }


    /**
     * user 动态帖子站内阅读uv
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/total-in-uv")
    public void totalInUv(@RequestParam("startDate")String startDate,
                           @RequestParam("endDate")String endDate,
                           HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename =  "站内动态帖子阅读uv.xlsx";
        String sql = "select substr(datetime,1,10) date , count(distinct userid) uv from wenxue_statistics.moka_stat_log_report where datetime >= " +
                " ?1 and datetime <= ?2 and `event` in ('/queryclubpostdetails','/queryDynamicDetails')  group by substr(datetime,1,10) order by substr(datetime,1,10) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, DataUv.class, startDate, endDate);
        exportExcelService.export(filename, response, null, list);
    }


    /**
     * user 动态帖子阅读uv
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/total-uv")
    public void totalUv(@RequestParam("startDate")String startDate,
                          @RequestParam("endDate")String endDate,
                          HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename =  "全站动态帖子阅读uv.xlsx";
        String sql = "select substr(datetime,1,10) date  , count(distinct deviceId) uv from wenxue_statistics.moka_stat_log_report where datetime >=  " +
                "?1 and datetime <= ?2 and `event` in ('/queryclubpostdetails','/queryDynamicDetails','liveMessagePV','clubPostPV')  group by substr(datetime,1,10) order by substr(datetime,1,10) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, DataUv.class, startDate, endDate);
        exportExcelService.export(filename, response, null, list);
    }



}
