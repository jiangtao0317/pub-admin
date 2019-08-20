package com.fanle.moka.controller;


import com.fanle.moka.service.ExportExcelService;
import com.fanle.moka.service.NativeQueryBaseService;
import com.fanle.moka.vo.ButtonVo;
import com.fanle.moka.utils.StringTransferUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/moka/content/")
@Slf4j
public class CommonDataController {

    @Autowired
    NativeQueryBaseService nativeQueryBaseService ;

    @Autowired
    ExportExcelService exportExcelService ;

    @RequestMapping("/find-button")
    public void in(@RequestParam("startDate")String startDate,
                   @RequestParam("endDate")String endDate,
                   HttpServletResponse response){
        startDate = StringTransferUtil.startDateStr(startDate);
        endDate =StringTransferUtil.endDateStr(endDate);
        String filename = "发现按钮点击PV/UV.xlsx";
        String sql = "SELECT\n" +
                "\tcount( distinct userid) uv,\n" +
                "\tcount( *) pv,\n" +
                "\tSUBSTR( datetime, 1, 10 ) date\n" +
                "FROM\n" +
                "\twenxue_statistics.moka_stat_log_report \n" +
                "WHERE\n" +
                "\t`event` = 'clickBottomNavigationReadingFriend' \n" +
                "\tAND datetime >= ?1 \n" +
                "\tAND datetime <= ?2\n" +
                "\tGROUP BY\n" +
                "\tSUBSTR( datetime, 1, 10 )";
        // baseService.export(filename,null,response,sql, c,startDate,endDate);
        List list = nativeQueryBaseService.nativeQuery(sql, ButtonVo.class,startDate,endDate);
        exportExcelService.export(filename,response,null,list);
    }
}
