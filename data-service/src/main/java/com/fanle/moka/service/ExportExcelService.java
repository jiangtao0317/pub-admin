package com.fanle.moka.service;

import com.fanle.moka.utils.ExcelUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ExportExcelService {

    public <S,T> void export(String filename, HttpServletResponse response ,ListContentFormatService<S, T> format, List<S> list){
        ExcelUtil excelUtil = new ExcelUtil();
        if(format!=null){
            List<T> targetList = Lists.newArrayList() ;
            targetList = format.format(list,targetList);
            excelUtil.export(filename, response, targetList);
        }else{
            excelUtil.export(filename, response, list);
        }
    }
}
