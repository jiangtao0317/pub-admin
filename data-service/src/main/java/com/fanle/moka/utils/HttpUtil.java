package com.fanle.moka.utils;

import net.sf.json.JSONArray;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLHandshakeException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.function.Function;

/**
 * @author maixingjie
 * @version 1.0
 * @describe HttpUtil.java
 * @date 2011-9-25
 */

public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    /**
     * http 请求的超时值，由配置文件中的http_timeout值设置
     */
    public static int CONNECTION_TIMEOUT = 60000;

    /**
     * 需要编码的内容的字符集
     */
    public static String CHARSET = "UTF-8";

    /**
     * 将最大连接数增加
     */
    private static int maxTotal = 200;

    /**
     * 将每个路由基础的连接增加
     */
    private static int maxPerRoute = 10;

    private static CloseableHttpClient httpClient = null;
    private final static Object syncLock = new Object();

    private HttpUtil() {
    }


    /**
     * Description:Using GET method.
     *
     * @param url    请求的url.
     * @param params key-value格式的请求参数
     * @return 字符串格式的返回内容
     * @author maixingjie
     * @date 2015-4-14
     */
    public static String get(String url, Map<String, String> params) {
        return get(url, params, CONNECTION_TIMEOUT);
    }

    public static String get(String url, Map<String, String> params, int connectionTimeoutMills) {
        if (StringTools.isEmpty(url)) {
            logger.debug("err - url=" + url + "&params=" + params);
            return null;
        }
        String result = null;
//        for (String key : params.keySet()) {
//            try {
//                if (params != null && params.size() > 0) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("&").append(key).append("=").append(URLEncoder.encode(params.get(key), CHARSET));
//                    if (-1 == url.indexOf("?")) {
//                        url += sb.toString().replaceFirst("&", "?");
//                    } else {
//                        url += sb.toString();
//                    }
//                }
//            } catch (UnsupportedEncodingException e) {
//                logger.error("HttpUtil urlencode get param error",e );
//            }
//
//        }
        try {
            if (url == null) {
                return null;
            }
            HttpGet httpget = new HttpGet(getUri(url,params));
            config(httpget, connectionTimeoutMills);
            result = getHttpClient().execute(httpget,
                    new ResponseHandler<String>() {
                        @Override
                        public String handleResponse(HttpResponse response) throws IOException {
                            int status = response.getStatusLine().getStatusCode();
                            if (status == HttpStatus.SC_OK) {
                                HttpEntity entity = response.getEntity();
                                return entity != null ? EntityUtils.toString(entity, HttpUtil.CHARSET) : null;
                            } else {
                                logger.error("HttpUtil response an error code : [{}].", status);
                                return "";
                            }
                        }
                    }
            );
        } catch (IOException e) {
            logger.error("HttpUtil.sendGet.", e);
        } finally {
            logger.info("sendGet url={},result={}", url, result);
        }
        return result;
    }

    public static String get(String url, int connectionTimeoutMills) {
        if (StringTools.isEmpty(url)) {
            logger.debug("err - url=" + url );
            return null;
        }
        String result = null;
        try {
            if (url == null) {
                return null;
            }
            HttpGet httpget = new HttpGet(url);
            config(httpget, connectionTimeoutMills);
            result = getHttpClient().execute(httpget,
                    new ResponseHandler<String>() {
                        @Override
                        public String handleResponse(HttpResponse response) throws IOException {
                            int status = response.getStatusLine().getStatusCode();
                            if (status == HttpStatus.SC_OK) {
                                HttpEntity entity = response.getEntity();
                                return entity != null ? EntityUtils.toString(entity, HttpUtil.CHARSET) : null;
                            } else {
                                logger.error("HttpUtil response an error code : [{}].", status);
                                return "";
                            }
                        }
                    }
            );
        } catch (IOException e) {
            logger.error("HttpUtil.sendGet.", e);
        } finally {
            logger.info("sendGet url={},result={}", url, result);
        }
        return result;
    }

    public static String post(String url, NameValuePair[] paramArray) {
        return post(url, paramArray, null);
    }

    public static MutablePair<Integer, String> sendBodyPost(String url, String body) {
        return sendBodyPost(url, body, null);
    }
    public static MutablePair<Integer, String> sendBodyPost(String url, String body, Map<String, String> header) {
        MutablePair<Integer, String> result = new MutablePair<>( -1, "sendBodyPost failed" );
        try {
            if (url == null) {
                return null;
            }
            HttpPost post = new HttpPost(url);
            if (MapUtils.isNotEmpty(header)) {
                header.forEach((k, v) -> {
                    post.addHeader(k, v);
                });
            }
            config(post, HttpUtil.CONNECTION_TIMEOUT);
            post.setEntity(new ByteArrayEntity(body.getBytes("utf-8")));
            result = getHttpClient().execute(post,
                    new ResponseHandler<MutablePair<Integer, String>>() {
                        @Override
                        public MutablePair<Integer, String> handleResponse(HttpResponse response) throws IOException {
                            int status = response.getStatusLine().getStatusCode();
                            HttpEntity entity = response.getEntity();
                            if (status == HttpStatus.SC_OK) {
                                return new MutablePair<>(status, entity != null ? EntityUtils.toString(entity, HttpUtil.CHARSET) : null);
                            } else {
                                return new MutablePair<>(status, entity != null ? EntityUtils.toString(entity, HttpUtil.CHARSET) : null);
                            }
                        }
                    }
            );
        } catch (IOException e) {
            logger.error("HttpUtil.sendBodyPost.", e);
        } finally {
            logger.info("sendBodyPost url={},body={},result={}", url, body, result.getValue ());
        }
        return result;
    }

    public static String post(String url, NameValuePair[] paramArray, Map<String, String> header) {
        String result = null;
        try {
            if (url == null) {
                return null;
            }
            HttpPost post = new HttpPost(url);
            if (MapUtils.isNotEmpty(header)) {
                header.forEach((k, v) -> {
                    post.addHeader(k, v);
                });
            }
            config(post, HttpUtil.CONNECTION_TIMEOUT);
            post.setEntity(new UrlEncodedFormEntity(Arrays.asList(paramArray),"utf-8"));
            result = getHttpClient().execute(post,
                    new ResponseHandler<String>() {
                        @Override
                        public String handleResponse(HttpResponse response) throws IOException {
                            int status = response.getStatusLine().getStatusCode();
                            if (status == HttpStatus.SC_OK) {
                                HttpEntity entity = response.getEntity();
                                return entity != null ? EntityUtils.toString(entity, HttpUtil.CHARSET) : null;
                            }else if(status == HttpStatus.SC_MOVED_TEMPORARILY){
                                String locationUrl=response.getLastHeader("Location").getValue();
                                return get(locationUrl,CONNECTION_TIMEOUT);
                            }else {
                                logger.error("HttpUtil response an error code : [{}].", status);
                                return "";
                            }
                        }
                    }
            );
        } catch (IOException e) {
            logger.error("HttpUtil.sendPost.", e);
        } finally {
            logger.info("sendPost url={},param={},result={}", url, JSONArray.fromObject(paramArray), result);
        }
        return result;
    }


    public static String doPostArray(String url, List<LinkedHashMap> list) {
        String encoding = "UTF-8";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost=null;
        CloseableHttpResponse response=null;
        try {
            String json = com.alibaba.fastjson.JSONArray.toJSONString(list);
            httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(json));
            httpPost.addHeader("Content-Type", "application/json");
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(httpclient,response);
        }
        return null;
    }

    /**
     * 关闭连接 释放资源
     * @param httpClient
     * @param response
     */
    public static void close(CloseableHttpClient httpClient, CloseableHttpResponse response){
        try {
            if(response!=null){
                response.close();
            }
            if(httpClient!=null){
                httpClient.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param baseurl
     * @param param
     * @return
     */
    private static URI getUri(String baseurl, Map<String, String> param) {
        URIBuilder builder = null;
        try {
            builder = new URIBuilder(baseurl);
            if (param != null) {
                Set<String> keySet = param.keySet();
                for (String key : keySet) {
                    //无需解码后在编码，直接代理
                    builder.setParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            logger.debug("HttpUtil uri : {}", uri.toString());
            return uri;
        } catch (URISyntaxException e) {
            logger.error("HttpClient.getUri.", e);
        }
        return null;
    }

    /**
     * 创建HttpClient对象
     *
     * @return
     */
    private static CloseableHttpClient createHttpClient() {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();

        Registry<ConnectionSocketFactory> registry = RegistryBuilder
                .<ConnectionSocketFactory>create().register("http", plainsf).build();

        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setCharset(Consts.UTF_8)
                .build();

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                registry);
        cm.setDefaultConnectionConfig(connectionConfig);

        cm.setMaxTotal(maxTotal);
        cm.setDefaultMaxPerRoute(maxPerRoute);
        // 将目标主机的最大连接数增加
//        HttpHost httpHost = new HttpHost(hostname, port);
//        cm.setMaxPerRoute(new HttpRoute(httpHost), maxRoute);

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception,
                                        int executionCount, HttpContext context) {
                if (executionCount >= 3) {// 如果已经重试了5次，就放弃
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// 超时
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext
                        .adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler).build();
        return httpClient;
    }

    private static void config(HttpRequestBase httpRequestBase,
                               int connectTimeout) {
        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectTimeout)
                .setSocketTimeout(connectTimeout)
                .build();
        httpRequestBase.setConfig(requestConfig);
    }

    /**
     * 获取HttpClient对象
     *
     * @return
     * @author SHANHY
     * @create 2015年12月18日
     */
    private static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (syncLock) {
                if (httpClient == null) {
                    httpClient = createHttpClient();
                }
            }
        }
        return httpClient;
    }

    //发送响应流方法
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
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
    //发送响应流方法
    public static <T> void exportXls(HttpServletResponse response, String fileName, List<T> data, Function<T,String[]> function, String[] column) {
        try{
            HSSFWorkbook hwb=getExportExcelForXls(data,function,column);
            setResponseHeader(response,fileName);
            OutputStream os = response.getOutputStream();
            hwb.write(os);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("导出失败！");
        }
    }
    //获取导出excel
    public static <T> HSSFWorkbook getExportExcelForXls( List<T> data, Function<T,String[]> function, String[] column) {
        HSSFWorkbook hwb = new HSSFWorkbook();
        try{
            HSSFSheet sheet = hwb.createSheet();
            HSSFRow row =sheet.createRow(0);
            int size = data == null ? 0 : data.size();
            for (int i=0;i<column.length;i++){
                row.createCell(i).setCellValue(column[i]);
            }
            String[] columnValue;
            for(int i = 0 ;i<size; i++){
                columnValue=function.apply(data.get(i));
                row=sheet.createRow(i+1);
                for (int j=0;j<columnValue.length;j++){
                    row.createCell(j).setCellValue(columnValue[j]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("导出失败！");
        }
        return hwb;
    }
    //发送响应流方法
    public static <T> void exportXlsx(HttpServletResponse response, String fileName, List<T> data, Function<T,String[]> function, String[] column) {
        try{
            XSSFWorkbook hwb=getExportExcelForXlsx(data,function,column);
            setResponseHeader(response,fileName);
            OutputStream os = response.getOutputStream();
            hwb.write(os);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("导出失败！");
        }
    }
    //获取导出excel
    public static <T> XSSFWorkbook getExportExcelForXlsx( List<T> data, Function<T,String[]> function, String[] column) {
        XSSFWorkbook hwb = new XSSFWorkbook();
        try{
            XSSFSheet sheet = hwb.createSheet();
            XSSFRow row =sheet.createRow(0);
            int size = data == null ? 0 : data.size();
            for (int i=0;i<column.length;i++){
                row.createCell(i).setCellValue(column[i]);
            }
            String[] columnValue;
            for(int i = 0 ;i<size; i++){
                columnValue=function.apply(data.get(i));
                row=sheet.createRow(i+1);
                for (int j=0;j<columnValue.length;j++){
                    row.createCell(j).setCellValue(columnValue[j]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("导出失败！");
        }
        return hwb;
    }
}
