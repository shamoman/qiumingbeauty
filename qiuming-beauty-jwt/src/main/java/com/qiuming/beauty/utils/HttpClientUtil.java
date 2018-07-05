package com.qiuming.beauty.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Http调用工具类
 * @author: yeliu
 * @date: 2017年6月20日 深圳天源迪科信息技术股份有限公司 版权所有.
 */
public class HttpClientUtil {

    public static <T> T getRequestDate(String url, Object param, String timeout,
                                       Class<T> c) throws IOException {
        JSONObject jsonObject = getRequestDate(url,param,timeout);
        T Object = JSONObject.toJavaObject(jsonObject, c);
        return Object;

    }
    public static JSONObject getRequestDate(String url, Object param, String timeout) throws IOException {
        int timeoutInt=1000;
        if(!StringUtils.isEmpty(timeout))
        {
            timeoutInt=Integer.parseInt(timeout);
        }
        String content = sendRequest(url, param, timeoutInt);
        JSONObject parseObject = JSONObject.parseObject(content);

//        JSONObject jsonObject = parseObject.getJSONObject("data");
        return parseObject;

    }
    public static <T> List<T> getRequestListDate(String url, Object param, String timeout,
                                                 Class<T> c) throws IOException {
        int timeoutInt=1000;
        if(!StringUtils.isEmpty(timeout))
        {
            timeoutInt=Integer.parseInt(timeout);
        }
        List<T> resultList=new ArrayList<T>();
        String content = sendRequest(url, param, timeoutInt);
        JSONObject parseObject = JSONObject.parseObject(content);
//        JSONArray data=JSONArray.parseArray(jsonData);
        for (int i=0;i<parseObject.size();i++) {
            JSONObject object=(JSONObject)parseObject.get(i);
            T resultObject = JSONObject.toJavaObject(object, c);
            resultList.add(resultObject);
        }
        return resultList;

    }

    public static String sendRequest(String url, Object param, int timeout)
            throws IOException {
        HttpURLConnection connection = HttpClientUtil.getConnectionInfo(url, timeout);

        DataOutputStream dops = new DataOutputStream(
                connection.getOutputStream());
        try {
            String content = JSONObject.toJSONString(param);
            dops.write(content.getBytes("UTF-8"));
            dops.flush();
            dops.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prinResponseData(connection);
    }

    /*
     * 获取链接
     *
     * @author: yeliu
     *
     * @date: 2017年6月20日
     */
    private static HttpURLConnection getConnection(String urlStr, int timeout) {
        URL url;
        HttpURLConnection urlConn = null;
        try {
            url = new URL(urlStr);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("POST");
            urlConn.setUseCaches(false);
            urlConn.setInstanceFollowRedirects(true);
            urlConn.setRequestProperty("Content-Type",
                    "application/json; UTF-8");
            urlConn.setConnectTimeout(timeout);// 设置超时时间
            urlConn.setReadTimeout(timeout);// 设置超时时间
            urlConn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlConn;
    }

    /**
     * GET 方式请求
     *
     * @author: yeliu
     * @param urlStr
     * @param timeout
     * @return
     */
    private static HttpURLConnection getConnectionInfo(String urlStr,
                                                       int timeout) {
        URL url;
        HttpURLConnection urlConn = null;
        try {
            url = new URL(urlStr);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("GET");
            urlConn.setUseCaches(false);
            urlConn.setInstanceFollowRedirects(true);
            urlConn.setRequestProperty("Content-Type",
                    "application/json; UTF-8");
            // urlConn.setConnectTimeout(timeout);//设置超时时间
            // urlConn.setReadTimeout(timeout);//设置超时时间
            urlConn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlConn;
    }

    /*
     * 获取数据
     *
     * @author: yeliu
     *
     * @date: 2017年6月20日
     */
    private static String prinResponseData(HttpURLConnection urlConn)
            throws IOException {
        byte[] bytes = readBytes(urlConn.getInputStream());
        urlConn.disconnect();
        String resultData = new String(bytes, "UTF-8");
//        String formatJson = JsonFormatTool.formatJson(resultData);
        return resultData;
    }

    private static byte[] readBytes(InputStream in) throws IOException {
        int size = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        while ((size = in.read(bytes)) != -1) {
            out.write(bytes, 0, size);
        }
        return out.toByteArray();
    }
}
