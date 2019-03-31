package 课后习题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*四、往一个Map集合中添加若干元素。获取Map中的所有value，并使用增强for和迭代器遍历输出每个value。
* 增强for和迭代器不能在Map集合中使用,所以必须先创建一个list集合*/
public class Test2 {
    public static void main(String[] args) {
        //创建一个Map集合
        Map<String ,String> map = new HashMap<>();
        //添加元素
        map.put("你","好");
        map.put("他","不好");
        map.put("李华","很不好");
        map.put("小李","很好");
        map.put("小飞","也不好");
        //获取Map中的value
        String s = map.get("你");
        String s1 = map.get("他");
        String s2= map.get("李华");
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(map.get("小李"));
        System.out.println(map.get("小飞"));
        System.out.println("=========");
        //创建一个ArrayList集合
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add(s);
        list.add(s1);
        list.add(s2);
        //用增强for遍历集合 list.iter  +  enter
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("======");
        //用迭代器遍历集合  list.iterator().var获取迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string =  iterator.next()      ;
            System.out.println(string);
        }
    }
}
