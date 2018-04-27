package com.king;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * httpClient工具类
 * @author wangchangyong
 * @create 2018/04/27 15:17
 */
public class HttpClientUtilTest {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        // 创建http链接池
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);

        //创建httpClient
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        //配置requestConfig
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(2000).build();

        HttpPost httpPost = new HttpPost("https://localhost:8080/login/login");
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Content-Type","application/json;charset=UTF-8");

//        List<NameValuePair> urlParameters = new ArrayList<>();
//        urlParameters.add(new BasicNameValuePair("name","123"));
//        HttpEntity httpEntity = new UrlEncodedFormEntity(urlParameters);

        String json = "{\"mobile\":\"18018662810\"}";
        StringEntity entity = new StringEntity(json, Consts.UTF_8);
        httpPost.setEntity(entity);

        //执行execute
        CloseableHttpResponse response = httpClient.execute(httpPost);

        System.err.println("请求地址: " + httpPost.getURI());
        System.err.println("响应状态: " + response.getStatusLine());
        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
            System.err.println("响应长度: " + responseEntity.getContentLength());
            System.err.println("响应内容: " + EntityUtils.toString(response.getEntity(), "UTF-8"));
        }

    }



}
