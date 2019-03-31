package shipindaima.src.hm05_jiexi;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Demo3 {
    public static void main(String[] args) throws DocumentException {

         // 创建 SAXReader

        SAXReader sr  = new SAXReader();

        // 读取 配置文件
        Document doc  = sr.read("bean.xml");

        // 获取所有property
        List<Node> list = doc.selectNodes("//property");

        for (Node node : list) {
            System.out.println(node);
        }

        // id 为u1的bean //BBB[@id='b1']
        Node bean  = doc.selectSingleNode("//bean[@id='s1']");
        System.out.println(bean);



    }
}
