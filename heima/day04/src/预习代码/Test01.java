package 预习代码;

import java.util.HashMap;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {
        //创建一个HashMap集合
        HashMap<String,String> map = new HashMap<>();
        //集合里添加元素
        map.put("大朗","金莲");
        map.put("二朗","老虎");
        map.put("三朗","小莲");
        System.out.println(map);
        //遍历集合
        //用keySet()获取存放key的集合
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            //获取值
            map.get(key);
            System.out.println(key +"=="+map.get(key));
        }

    }
}
