package com.itheima.crawler.httpclient;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class GetParamsTest {
    public static void main(String[] args) throws URISyntaxException {
        // 创建HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 使用URIBulider进行请求参数的构建
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search")
                .setParameter("keys","java")
                .setParameter("keys","123");
        // 创建HttpGet
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = null;
        try {
            // 用HttpClient发送请求
             response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                FileUtils.writeStringToFile(new File("D:\\temp\\jd1.html"),content,"UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
