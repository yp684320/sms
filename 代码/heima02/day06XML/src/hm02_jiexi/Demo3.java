package hm02_jiexi;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo3 {
    public static void main(String[] args) throws DocumentException {
        //获取SAXreader对象
        SAXReader sr = new SAXReader();
        //读取文档 获取文档对象
        Document document = sr.read("Demo3.xml");
        //获取根元素
        Element root = document.getRootElement();
        System.out.println(root.getName());
        //通过根元素获取子元素
        List<Element> list = root.elements();
        //遍历集合
        for (Element property : list) {
            String value = property.attributeValue("value");
            System.out.println(value);
        }
    }
}
