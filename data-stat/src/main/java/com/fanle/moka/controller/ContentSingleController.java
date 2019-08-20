package com.fanle.moka.controller;


import com.fanle.moka.constant.SystemConstant;
import com.fanle.moka.service.BaseService;
import com.fanle.moka.service.ExportExcelService;
import com.fanle.moka.service.NativeQueryBaseService;
import com.fanle.moka.utils.StringTransferUtil;
import com.fanle.moka.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/moka/content/single")
@Slf4j
public class ContentSingleController extends ContentController{

    @Autowired
    BaseService baseService ;

    @Autowired
    NativeQueryBaseService nativeQueryBaseService ;

    @Autowired
    ExportExcelService exportExcelService ;

    /**
     * 个人站内uv/pv
     * @param startDate
     * @param endDate
     * @param userid
     * @param type
     * @param response
     */
    @RequestMapping("/in")
    public void in(@RequestParam("startDate")String startDate,
                     @RequestParam("endDate")String endDate,
                     @RequestParam(name="userid")String userid,
                     @RequestParam(name="type",defaultValue = "pv")String type,
                     HttpServletResponse response){
        Class c = ContentPv.class ;
        String coutSql = "count(*) "+type+" ";
        if(StringUtils.equalsIgnoreCase(SystemConstant.UV,type)){
            coutSql = "count(distinct a.userid) "+type+ " ";
            c = ContentUv.class ;
        }
        String filename = "账号"+userid+"动态帖子站内阅读"+type+".xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
               coutSql+
                "\tFROM\n" +
                "\twenxue_statistics.moka_stat_log_report a , wenxue_dynamic.dynamic b\n" +
                "\tWHERE\n" +
                "\t( a.`event` = '/queryclubpostdetails' OR a.`event` = '/queryDynamicDetails' ) \n" +
                "\tand a.browser not in \n" +BaseService.collectionToString(out_browsers)+
                "\tand a.datetime >= ?1\n" +
                "\tand a.datetime <= ?2\n" +
                "\tAND a.ext0 = b.dynamicid And b.userid = ?3 \n" +
                "\tGROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 )\n" +
                "\tORDER BY SUBSTR( datetime, 1, 10 ) asc";
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql,c,startDate,endDate,userid);
        exportExcelService.export(filename,response,null,list);
    }

    @RequestMapping("/out")
    public void out(@RequestParam("startDate")String startDate,
                   @RequestParam("endDate")String endDate,
                   @RequestParam(name="userid")String userid,
                   @RequestParam(name="type",defaultValue = "pv")String type,
                   HttpServletResponse response){
        Class c = ContentPv.class ;
        String coutSql = "count(*) "+type+" ";
        if(StringUtils.equalsIgnoreCase(SystemConstant.UV,type)){
            coutSql = "count(distinct a.deviceId) "+type+ " ";
            c = ContentUv.class ;
        }
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "账号"+userid+"动态帖子站外阅读"+type+".xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
               coutSql+
                "\tFROM\n" +
                "\twenxue_statistics.moka_stat_log_report a , wenxue_dynamic.dynamic b\n" +
                "\tWHERE\n" +
                "\t( a.`event` = 'liveMessagePV' OR a.`event` = 'clubPostPV' ) \n" +
                "\tand a.browser in \n" +BaseService.collectionToString(out_browsers)+
                "\tand a.datetime >= ?1\n" +
                "\tand a.datetime <= ?2\n" +
                "\tAND a.coid = b.dynamicid And b.userid = ?3 \n" +
                "\tGROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 )\n" +
                "\tORDER BY SUBSTR( datetime, 1, 10 ) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql,c,startDate,endDate,userid);
        exportExcelService.export(filename,response,null,list);
    }

    /**
     * user 动态帖子发表数量
     * @param startDate
     * @param endDate
     * @param userid
     * @param response
     */
    @RequestMapping("/number")
    public void number(@RequestParam("startDate")String startDate,
                       @RequestParam("endDate")String endDate,
                       @RequestParam(name="userid")String userid,
                       HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "账号" + userid + "动态帖子发表数量.xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( creatdate, 1, 10 ) as date,\n" +
                "\tCOUNT( dynamicid ) as number \n" +
                "FROM\n" +
                "\twenxue_dynamic.dynamic a \n" +
                "WHERE\n" +
                "\ta.creatdate >= ?1\n" +
                "\tand a.creatdate <= ?2\n" +
                "\tand a.userid = ?3 \n" +
                "\tand a.bigType in ('1','3')" +
                "GROUP BY\n" +
                "\tSUBSTR( creatdate, 1, 10 )\n" +
                "\tORDER BY SUBSTR( creatdate, 1, 10 ) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, ContentNumber.class, startDate, endDate, userid);
        exportExcelService.export(filename, response, null, list);
    }

    /**
     * user 动态帖子评论次数
     * @param startDate
     * @param endDate
     * @param userid
     * @param response
     */
    @RequestMapping("/comment-times")
    public void times(@RequestParam("startDate")String startDate,
                      @RequestParam("endDate")String endDate,
                      @RequestParam(name="userid")String userid,
                      HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "账号" + userid + "动态帖子评论次数.xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( creatdate, 1, 10 ) as date,\n" +
                "\tsum(a.commenttimes) number\n" +
                "\tFROM\n" +
                "\twenxue_dynamic.dynamic a \n" +
                "\tWHERE\n" +
                "\ta.creatdate >= ?1\n" +
                "\tand a.creatdate <= ?2\n" +
                "\tand a.userid =?3 \n"+
                "\tand a.bigType in ('1','3')\n" +
                "\tGROUP BY\n" +
                "\tSUBSTR( creatdate, 1, 10 )\n" +
                "\tORDER BY SUBSTR( creatdate, 1, 10 ) asc";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, ContentNumber.class, startDate, endDate, userid);
        exportExcelService.export(filename, response, null, list);
    }


    /**
     * 单条 动态帖子站外pv/uv
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/content-out")
    public void contentOut(@RequestParam("startDate")String startDate,
                      @RequestParam("endDate")String endDate,
                      HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename =  "单条动态帖子站外pv/uv.xlsx";
        String sql = "SELECT\n" +
                "\tcount(*) pv,count(distinct a.unionid) uv,\n" +
                "\tSUBSTR( datetime, 1, 10 ) date,\n" +
                "\tconcat(b.dynamicid) dynamicId,\n" +
                "\tb.content content\n" +
                "FROM\n" +
                "\twenxue_statistics.moka_stat_log_report a , wenxue_dynamic.dynamic b\n" +
                "WHERE\n" +
                "\t( a.`event` = 'liveMessagePV' OR a.`event` = 'clubPostPV' ) \n" +
                "\tand a.browser in ('wb','wx','qq')\n" +
                "\tand a.datetime >= ?1\n" +
                "\tand a.datetime <= ?2\n" +
                "\tAnd b.userid in \n" +BaseService.collectionToString(userids)+
                "\tAND a.coid = b.dynamicid  \n" +
                "GROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 )\n" +
                "\t,b.dynamicid\n" +
                "\tORDER BY b.dynamicid asc,SUBSTR( datetime, 1, 10 ) asc \n";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, DynamicVo.class, startDate, endDate);
        exportExcelService.export(filename, response, null, list);
    }

    /**
     * 单条 动态帖子站外pv/uv
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/content-in")
    public void contentIn(@RequestParam("startDate")String startDate,
                        @RequestParam("endDate")String endDate,
                        HttpServletResponse response) {
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename =  "单条动态帖子站内pv/uv.xlsx";
        String sql = "SELECT\n" +
                "\tSUBSTR( a.datetime, 1, 10 ) date,\n" +
                "\tcount( distinct a.deviceId\t) uv,\n" +
                "\tcount( * ) pv,\n" +
                "\tconcat(b.dynamicid) dynamicId,\n" +
                "\tb.content content\n" +
                "FROM\n" +
                "\twenxue_statistics.moka_stat_log_report a , wenxue_dynamic.dynamic b\n" +
                "WHERE\n" +
                "\t( a.`event` = '/queryclubpostdetails' OR a.`event` = '/queryDynamicDetails' ) \n" +
                "\tand a.platform in ('android','ios')\n" +
                "\tand a.datetime >= ?1\n" +
                "\tand a.datetime <= ?2\n" +
                "\tAND a.ext0 = b.dynamicid And b.userid in \n" +BaseService.collectionToString(userids)+
                "GROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 ),b.dynamicid\n" +
                "\tORDER BY b.dynamicid asc ,SUBSTR( datetime, 1, 10 ) asc\n";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, DynamicVo.class, startDate, endDate);
        exportExcelService.export(filename, response, null, list);
    }

    @RequestMapping("/share")
    public void share(@RequestParam("startDate")String startDate,
                    @RequestParam("endDate")String endDate,
                    @RequestParam(name="userid")String userid,
                    HttpServletResponse response){
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "账号"+userid+"动态帖子站外阅读.xlsx";
        String sql = "SELECT\n" +
                "\tcount( * ) pv,\n" +
                "\tcount( distinct a.userid ) uv,\n" +
                "\tSUBSTR( a.date, 1, 10 ) '日期' ,\n" +
                "\tb.userid\n" +
                "FROM\n" +
                "\twenxue_user.share_record a,\n" +
                "\twenxue_dynamic.dynamic b \n" +
                "WHERE\n" +
                "\ta.ext1 = b.dynamicid \n" +
                "\tAND a.shareid IN ( '5', '12' ) \n" +
                "\tAND a.date >= '2019-04-15' \n" +
                "\tAND a.date <= '2019-04-22' \n" +
                "\tand b.userid IN " +userids+
                "\tGROUP BY \n" +
                "b.userid ,SUBSTR( a.date, 1, 10 )\n" +
                "ORDER BY b.userid asc ,SUBSTR( a.date, 1, 10 ) asc ";
        //baseService.export(filename,null,response,sql, c,startDate,endDate,userid);
        List list = nativeQueryBaseService.nativeQuery(sql, ContentShareVo.class,startDate,endDate,userid);
        exportExcelService.export(filename,response,null,list);
    }

}
