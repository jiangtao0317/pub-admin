package com.fanle.moka.service;

import com.fanle.moka.utils.ExcelUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Slf4j
public class ExportExcelService {

    public <S,T> void export(String filename, HttpServletResponse response ,ListContentFormatService<S, T> format, List<S> list){
        ExcelUtil excelUtil = new ExcelUtil();
        if(format!=null){
            List<T> targetList = Lists.newArrayList() ;
            targetList = format.format(list,targetList);
            if(CollectionUtils.isEmpty(targetList)){
                log.info("sourceList集合为空：");
                return ;
            }
            excelUtil.export(filename, response, targetList);
        }else{
            if(CollectionUtils.isEmpty(list)){
                log.info("sourceList集合为空：");
                return ;
            }
            excelUtil.export(filename, response, list);
        }
    }
}
