package shipindaima.src.hm05_jiexi;
/*
 dom4j: 解析xml文件的工具包

 SaxReader : 使用Dom方式解析xml文档 .
     read(string path);  读取xml文档 .


Document : 表示 xml文档 .
    getRootElement() 获得根元素 , 每个xml中, 唯一的根元素.

elements(…) 获得指定名称的所有子元素。可以不指定名称 ,获取所有子标签.
attributeValue(...) 获取指定属性的值.
getText() 获得当前元素的文本内容.

 */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) throws DocumentException {

        // 创建SaxReader
        SAXReader sr = new SAXReader();

        // 读取 文档 , 返回文档对象
        Document doc = sr.read("bean.xml");
        System.out.println(doc);

        // 获取根元素  ,Element 表示元素 .
        Element root = doc.getRootElement();

        // 获取 root 的子元素

        List<Element> list = root.elements();

        // 遍历集合
        for (Element bean : list) {
            System.out.println(bean.getName());

            // 获取bean 子标签
            List<Element> elements = bean.elements();
            for (Element property : elements) {
                String name = property.attributeValue("name");
                String value = property.attributeValue("value");
                System.out.println(name+"="+value);

                // 获取 文本
                String text = property.getText();
                System.out.println(text);
            }

        }
    }
}
