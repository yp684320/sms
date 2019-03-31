package com.itheima.crawler.httpclient;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class GetTest {
    public static void main(String[] args) {
        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpGet请求
        HttpGet HttpGet = new HttpGet("http://www.jd.com");
        CloseableHttpResponse response = null;
        try {
            // 使用HttpClient发出HttpGet请求
            response = httpClient.execute(HttpGet);
            // 解析响应的结果
            // 判断响应状态码是否是200  如果是 标识访问成功
            if (response.getStatusLine().getStatusCode() == 200) {
                // 获取相应的内容
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                FileUtils.writeStringToFile(new File("D:\\temp\\itcast.html"),content,"UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
