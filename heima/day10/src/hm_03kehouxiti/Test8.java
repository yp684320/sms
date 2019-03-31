package hm_03kehouxiti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*练习八:IO对象Properties结合使用,设置properties文件
描述:
我有一个文本文件score.txt，我知道数据是键值对形式的，但是不知道内容是什么。
请写一个程序判断是否有"lisi"这样的键存在，如果有就改变其实为"100"
score.txt文件内容如下：
zhangsan = 90
lisi = 80
wangwu = 85
*/
public class Test8 {
    public static void main(String[] args) throws IOException {
        //创建属性集对象
        Properties pro = new Properties();
        //加载文本中信息到属性集
        pro.load(new FileInputStream("d:\\score.txt"));
        //遍历集合 打印
        Set<String> set = pro.stringPropertyNames();
        for (String s : set) {
            if (s.equals("lisi")) {
                pro.setProperty(s,"100");
            }

        }
        pro.store(new FileOutputStream("d:\\score.txt"), "haha");
       /* //1：创建一个空的集合
        Properties prop = new Properties();
//2:读取数据到集合中
        prop.load(new FileInputStream("d:\\score.txt"));
//3:遍历集合，获取到每一个key
        Set<String> keys = prop.stringPropertyNames();
//获取到每一个key
        for (String key : keys) {
//4:判断当前的key 是否为 "lisi"
            if ("lisi".equals(key)) {
//把"lisi"的值设置为100
                prop.setProperty(key, "100");
            }
        }
//把集合中所有的信息，重新存储到文件中
        prop.store(new FileOutputStream("d:\\score.txt"), "haha");*/
    }
}
