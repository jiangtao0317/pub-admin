package com.fanle.moka.utils;

import com.fanle.moka.annotation.Excel;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

public class ExcelUtil<T> {

    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param wb HSSFWorkbook对象
     * @return
     */
    public XSSFWorkbook getXSSFWorkbook(String sheetName, List<T> list, XSSFWorkbook wb) throws IllegalAccessException {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new XSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制

        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        XSSFCell cell ;

        //创建标题
       /* for(int i=0;i<title.length;i++){

            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }*/
        T t0 = list.get(0);
        Field[] fields1 = t0.getClass().getDeclaredFields() ;
        XSSFRow row = sheet.createRow(0);
        int e = 0 ;
        for(int i = 0 ; i < fields1.length ; i++){
            Excel excel = fields1[i].getAnnotation(Excel.class) ;
            if(excel==null){
                continue;
            }
            cell = row.createCell(e);
            cell.setCellValue(excel.name());
            cell.setCellStyle(style);
            e++ ;
        }


        for(int a = 0 ; a<list.size() ; a++){
            T t = list.get(a);
            Field[] fields = t.getClass().getDeclaredFields() ;
            row = sheet.createRow(a+1);
            int r = 0 ;
            for(int i = 0 ; i < fields.length ; i++){
                Excel excel = fields[i].getAnnotation(Excel.class) ;
                if(excel==null){
                    continue ;
                }
                if(fields[i].getType().equals(Date.class)){
                    if(StringUtils.isNotEmpty(excel.exportFormat())){
                        Date date = (Date)getFieldValueByName(fields[i].getName(),t);
                        row.createCell(r).setCellValue(DateUtil.toString(date,excel.exportFormat()));
                    }
                    r++ ;
                    continue ;
                }
                if(fields[i].getType().equals(String.class)){
                    String value = "";
                    Object o = getFieldValueByName(fields[i].getName(),t);
                    if(o!=null){
                        value = (String) o ;
                    }
                    XSSFCell cell1 = row.createCell(r) ;
                    if(excel.isLink()){
                        cell1.setCellFormula("HYPERLINK(\"" + value + "\",\"图片\")");
                        XSSFCellStyle linkStyle = wb.createCellStyle();
                        XSSFFont font = wb.createFont() ;
                        font.setColor(HSSFColor.BLUE.index);
                        linkStyle.setFont(font);
                        cell1.setCellStyle(linkStyle);
                    }else{
                        cell1.setCellValue(value);
                    }
                    r++;
                    continue ;
                }
//                if(excel.statusClass().equals(BaseEnum.class)){
//                    Object o = getFieldValueByName(fields[i].getName(),t);
//                    if(o!=null){
//                        if(o.getClass().equals(BaseEnum.getKeyType(o).getClass())){
//
//                            String value = BaseEnum.getName();
//                        }
//
//                    }
//                }
                Object o = getFieldValueByName(fields[i].getName(),t);
                if(o!=null){
                    row.createCell(r).setCellValue(o.toString());
                }
                r++;
            }
        }
        return wb;
    }

    private  Object getFieldValueByName(String fieldName, Object o) throws IllegalAccessException {
        Field field=getFieldByName(fieldName, o.getClass());
        field.setAccessible(true);
        Object value=field.get(o);
        return value;
    }

    /**
     * @MethodName  : getFieldByName
     * @Description : 根据字段名获取字段
     * @param fieldName 字段名
     * @param clazz 包含该字段的类
     * @return 字段

     */

    private  Field getFieldByName(String fieldName, Class<?>  clazz){
        //拿到本类的所有字段
        Field[] selfFields=clazz.getDeclaredFields();

        //如果本类中存在该字段，则返回
        for(Field field : selfFields){
            if(field.getName().equals(fieldName)){
                return field;
            }
        }

        //否则，查看父类中是否存在此字段，如果有则返回
        Class<?> superClazz=clazz.getSuperclass();
        if(superClazz!=null  &&  superClazz !=Object.class){
            return getFieldByName(fieldName, superClazz);
        }

        //如果本类和父类都没有，则返回空
        return null;
    }

    public void export(String filename,HttpServletResponse response,List<T> list){
        try {
            XSSFWorkbook workbook = this.getXSSFWorkbook("default",list,null);
            this.setResponseHeader(response, filename);
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

