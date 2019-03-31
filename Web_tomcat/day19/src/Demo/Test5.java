package Demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

//解析propertise
public class Test5 {
    public static void main(String[] args) throws IOException {
       /* Properties properties = new Properties();
        //传入的配置文件流
        InputStream resourceAsStream = Test5.class.getClassLoader().getResourceAsStream("redis.propertise");
        properties.load(resourceAsStream);
        String host = properties.getProperty("host");
        System.out.println(host);*/

        //介绍新的  工具类 resourcebundle
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        //获取配置
        String host = bundle.getString("host");
        System.out.println(host);
    }
}
