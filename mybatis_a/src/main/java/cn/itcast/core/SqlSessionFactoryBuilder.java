package cn.itcast.core;

import cn.itcast.domain.Configuration;
import cn.itcast.utils.XMLConfigBuilder;

import java.io.InputStream;

/*
 * 1,解析用户提供的配置文件,将解析的数据封装给configuration对象
 * 2,创建SQLSessionFactory对象,并传递configuration 对象*/
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory bulid(InputStream is) throws Exception {
        //解析用户提供的配置文件,将解析的数据封装给configuration对象
        Configuration configuration = XMLConfigBuilder.buildConfiguration(is);
        //创建SQLSessionFactory对象,并传递configuration 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory(configuration);

        return sqlSessionFactory;
    }
   /*public Configuration parseXml(InputStream is) throws DocumentException {
       Configuration configuration = new Configuration();
       //解析 封装
       SAXReader saxReader = new SAXReader();
      // InputStream is = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
       Document docnment = saxReader.read(is);//获取dom树
       Element root = docnment.getRootElement();//获取根标签
       List<Element> list = root.elements();
       for (Element element : list) {
           String name = element.attributeValue("name");//url  driver  username password
           String value = element.attributeValue("value");//root  ....
           //判断
           if ("driver".equals(name)) {
               configuration.setDriver(value);
           }

       }
       return configuration;
   }*/
}
