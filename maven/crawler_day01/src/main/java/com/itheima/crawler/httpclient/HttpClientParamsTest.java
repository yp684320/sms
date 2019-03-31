package com.itheima.crawler.httpclient;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class HttpClientParamsTest {
    public static void main(String[] args) {
        // 创建httpclient对象 相当于打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建httpGet请求  里面需要访问url路径  相当于输入url页面地址
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        // 创建HttpClient的请求参数对象  设置请求的参数(超时时间)
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(10*100)
                .setConnectionRequestTimeout(500)
                .build();
        CloseableHttpResponse response = null;
        try {
            // 使用httpClient发起HttpGet请求, 获取相应结果
             response = httpClient.execute(httpGet);
            // 解析响应的结果
            // 判断响应状态码是否是200  如果是 访问成功
            if (response.getStatusLine().getStatusCode() == 200) {
                // 获取相应的数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                FileUtils.writeStringToFile(new File("D:\\temp\\baidu.html"),content,"UTF-8");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 释放响应数据
        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 释放HttpClient对象
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
