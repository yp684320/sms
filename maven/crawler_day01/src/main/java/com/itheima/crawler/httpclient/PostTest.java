package com.itheima.crawler.httpclient;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class PostTest {
    public static void main(String[] args)  {
    // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpPost对象
        HttpPost httpPost = new HttpPost("http://www.jd.com");
        CloseableHttpResponse response = null;
        try {
            // 使用HttpClient发送HttpPost请求
            response = httpClient.execute(httpPost);
            // 处理结果
            // 判断状态码是否为200,如果是,访问成功
            if (response.getStatusLine().getStatusCode() == 200) {
                // 获取相应的数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                FileUtils.writeStringToFile(new File("D:\\temp\\jd.html"),content,"UTF-8");
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
