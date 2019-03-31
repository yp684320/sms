package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class BeanFactory {
    private  static Document document;
    static{
        try {
            //解析xml
            SAXReader saxReader = new SAXReader();

            //通过类加载器加载类路径下的资源  并且以流的方式返回
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
            //描述 xml配置文件的对象
            document = saxReader.read(inputStream);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public static <T>T newInstance(Class<T> interfaceClass){
        //使用方只是给了一个规范

        //解析配置文件  找到该接口 该规范的具体实现类
        String implClassName=getImplClassName(interfaceClass);

        //通过反射 创建 该实现类的对象
        try {
            Class<?> aClass = Class.forName(implClassName);

            //反射创建对象
            Object o = aClass.newInstance();
            return (T) o;


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static <T> String getImplClassName(Class<T> interfaceClass) {
        //获取interfaceClass类的接口的名字
        //这个方法用来获取类的名字 返回简单的名字  UserDaoInterface
        String name = interfaceClass.getSimpleName();

        //解析xml
        //SAXReader saxReader = new SAXReader();

        //通过类加载器加载类路径下的资源  并且以流的方式返回
        //InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");

        try {
            //描述 xml配置文件的对象
            //Document document = saxReader.read(inputStream);

            //根据name名字 查找 bean标签
            //快速选中某一个标签  传入参数 选择器 xpath选择器语法

            /**
             * 属性选择器 [@属性名='属性值']
             * 元素选择器 //元素名
             */
            Element element = (Element) document.selectSingleNode("//bean[@name='" + name + "']");

            String aClass = element.attributeValue("class");

            return aClass;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
