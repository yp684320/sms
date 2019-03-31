package 课后习题;

import java.util.HashMap;

//三、请使用Map集合的方法完成添加元素，根据键删除，以及根据键获取值操作。
public class Test1 {
    public static void main(String[] args) {
        //创建一个HashMap集合
        HashMap<String, String> map = new HashMap<>();
        //添加元素
        map.put("张飞","李飞");
        map.put("张凯","李楠");
        map.put("张华","李键");
        System.out.println(map);
        //根据键删除元素
        map.remove("张凯");
        System.out.println(map);
        //根据键获取值
        String value = map.get("张华");
       //System.out.println(map.get("张华"));
        System.out.println(value);

    }
}
