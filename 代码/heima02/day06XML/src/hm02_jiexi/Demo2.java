package hm02_jiexi;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws DocumentException {
        //创建SaxReader对象
        SAXReader rs = new SAXReader();
        //读取文档  返回文档对象
        Document document = rs.read("Demo2.xml");
        //获取根元素
        Element root = document.getRootElement();
        //通过根元素  获取子元素
        List<Element> list = root.elements();
        //遍历集合
        for (Element bean : list) {
            System.out.println(bean.getName());
            //获取子标签
            List<Element> list1 = bean.elements();
            //遍历集合
            for (Element property : list1) {
                String name = property.attributeValue("name");
                String value = property.attributeValue("value");
                System.out.println(name+" "+value);
                //获取文本
                String text = property.getText();
                System.out.println(text);
            }
        }
    }
}
