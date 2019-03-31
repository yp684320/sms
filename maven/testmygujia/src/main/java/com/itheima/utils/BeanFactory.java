package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {

    /**
     * 给出接口的类型就得返回一个具体实现类对象
     * @param interfaceClass
     * @param <T>
     * @return
     */
    public static <T>T newInstance(Class<T> interfaceClass){

        //根据传过来接口类型 找到最后那一刻 人决定使用哪个实现类
        //获取到接口的名字
        String simpleName = interfaceClass.getSimpleName();
        //根据接口的名字就解析配置文件

        SAXReader saxReader = new SAXReader();

        try {
            Document document = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));

            //使用xpath语法 真不会 忘记了解析语法 暂时放着  帮你获取对应元素

            Element ele = (Element) document.selectSingleNode("//bean[@name='" + simpleName + "']");
            //获取到子类的类的全限定名
            String aClass = ele.attributeValue("class");

            //反射获取该类
            Class<?> subClass = Class.forName(aClass);
            //反射创建对象
            return (T) subClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
