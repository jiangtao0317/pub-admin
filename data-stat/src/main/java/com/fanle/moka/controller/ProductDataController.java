package com.fanle.moka.controller;

import com.fanle.moka.utils.ExcelUtil;
import com.fanle.moka.vo.ProductAllDataVo;
import com.google.common.collect.Maps;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/moka")
public class ProductDataController {

    @PersistenceContext
    EntityManager entityManager ;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,String> map(){
        Map<String,String> map = Maps.newHashMap();
        map.put("hello","world");
        return map ;
    }



    @RequestMapping("/all-data")
    public void allData(@RequestParam("startDate")String startDate,
                        @RequestParam("endDate")String endDate,HttpServletResponse response){

        String sql = "SELECT\n" +
                "\ta.date 'date',\n" +
                "\tsum(a.shareAppPv) 'shareAppPvSum',\n" +
                "\tsum(a.shareAppUv) 'shareAppUvSum',\n" +
                "\tsum(a.readSec) 'readSecSum' ,\n" +
                "\tsum(a.readUserUv) 'readUserSum',\n" +
                "\tsum(a.onlineSec) 'onlineSum',\n" +
                "\tsum(a.bookUv) 'bookUvSum',\n" +
                "\tsum(a.loginAppStartPv) 'loginAppStartPvSum',\n" +
                "\tsum(a.login-a.loginGuest) 'accountLoginSum',\n" +
                "\tsum(a.loginGuest) 'loginGuestSum'\n" +
                "from wenxue_statistics.moka_stat_day a where a.date > ? and a.date < ?\n" +
                "and cid = 'all' and platform in ('android','ios') and version = 'all'\n" +
                "group by a.date";

        Query query2 = entityManager.createNativeQuery(sql).setParameter(1,startDate).setParameter(2,endDate);
        query2.unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(ProductAllDataVo.class));
        List list = query2.getResultList() ;
        if(CollectionUtils.isEmpty(list)){
            ProductAllDataVo productAllDataVo = new ProductAllDataVo() ;
            productAllDataVo.setDate("2019-03-04");
            list.add(productAllDataVo);
        }
        this.export(list,response);
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @param response
     */
    @RequestMapping("/appstart")
    public void appstart(@RequestParam("startDate")String startDate,
                        @RequestParam("endDate")String endDate,HttpServletResponse response){

        String sql = "SELECT\n" +
                "\ta.date 'date',\n" +
                "\tsum(a.shareAppPv) 'shareAppPvSum',\n" +
                "\tsum(a.shareAppUv) 'shareAppUvSum',\n" +
                "\tsum(a.readSec) 'readSecSum' ,\n" +
                "\tsum(a.readUserUv) 'readUserSum',\n" +
                "\tsum(a.onlineSec) 'onlineSum',\n" +
                "\tsum(a.bookUv) 'bookUvSum',\n" +
                "\tsum(a.loginAppStartPv) 'loginAppStartPvSum',\n" +
                "\tsum(a.login-a.loginGuest) 'accountLoginSum',\n" +
                "\tsum(a.loginGuest) 'loginGuestSum'\n" +
                "from wenxue_statistics.moka_stat_day a where a.date > ? and a.date < ?\n" +
                "and cid = 'all' and platform in ('android','ios') and version = 'all'\n" +
                "group by a.date";

        Query query2 = entityManager.createNativeQuery(sql).setParameter(1,startDate).setParameter(2,endDate);
        query2.unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean(ProductAllDataVo.class));
        List list = query2.getResultList() ;
        if(CollectionUtils.isEmpty(list)){
            ProductAllDataVo productAllDataVo = new ProductAllDataVo() ;
            productAllDataVo.setDate("2019-03-04");
            list.add(productAllDataVo);
        }
        this.export(list,response);
    }

    public void export(List list,HttpServletResponse response){
        ExcelUtil<ProductAllDataVo> excelUtil = new ExcelUtil<>();

        try {
            XSSFWorkbook workbook = excelUtil.getXSSFWorkbook("default",list,null);
            this.setResponseHeader(response, "产品数据-整体数据.xlsx");
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
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
