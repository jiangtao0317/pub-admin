package com.fanle.moka.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-08-14 17:22
 **/

@Slf4j
public class FileUtil {

    public static byte[] InputStream2ByteArray(String filePath) throws IOException {

        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();

        return data;
    }

    public static byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }


    public static List<Row> readExcel(byte[] in){
        InputStream sbs = new ByteArrayInputStream(in);
        XSSFWorkbook wb ;

        try {
            wb = new XSSFWorkbook(sbs);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> iterator = sheet.rowIterator();
            List<Row> rowList = Lists.newArrayList(iterator);
            return rowList ;
        } catch (IOException e) {
            log.info("read excel file exception:{}",e);
            return null ;
        }

    }
}
