package 预习代码;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        //创建HashMap集合对象
        HashMap<Student, String> map = new HashMap<>();
        //添加元素
        map.put(new Student("李凯",25),"上海");
        map.put(new Student("李飞",20),"北京");
        map.put(new Student("李华",23),"青岛");
        //取出元素  键找值方式
        Set<Student> set = map.keySet();
        //遍历Set集合  获取每一个键
        for (Student key : set) {
            String value = map.get(key);
            System.out.println(key+"    "+ value);
        }

    }
}
