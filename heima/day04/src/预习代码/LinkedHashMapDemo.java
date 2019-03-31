package 预习代码;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        //创建一个LinkedHashMap集合
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        //添加元素
        map.put("李晨","范冰冰");
        map.put("孙俪","邓超");
        map.put("李飞","范河");
        map.put("冯晨","李冰冰");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> entry : entrySet) {
            System.out.println(entry.getKey()+ "   "+entry.getValue());
        }


    }
}
