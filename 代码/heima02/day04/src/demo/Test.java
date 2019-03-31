package demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        HashMap<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "gogo");
        hashmap.put(2, "wade");
        hashmap.put(3, "james");
        hashmap.put(4, "curry");
        // 1. 通过Map.keySet遍历key和value：
        for (int key : hashmap.keySet()) {
            System.out.println("key: " + key + "; value: " + hashmap.get(key));
        }
        //2. 通过Map.entrySet使用iterator遍历key和value：
        Iterator<Map.Entry<Integer, String>> it = hashmap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String> entry = it.next();
            System.out.println("key: "+ entry.getKey() + "; value: " + entry.getValue());
        }

        //3. 通过Map.entrySet遍历key和value
        for(Map.Entry<Integer, String> entry : hashmap.entrySet()){
            System.out.println("key: "+ entry.getKey() + "; value: " + entry.getValue());
        }

        //4. 通过Map.values()遍历所有的value，但不能遍历key
        for (String value : hashmap.values()) {
            System.out.println("value: "+value);
        }

    }

}
