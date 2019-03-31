package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// String str = "asdhjhfjkhfnfjkaiuwiioejiojfkjgkldfsiopuerweofjlksfjgoierwurwd",求出每个字母的重复次数,并安重复次数由高到低排序
public class Test5 {
    public static void main(String[] args) {
        String str = "asdhjhfjkhfnfjkaiuwiioejiojfkjgkldfsiopuerweofjlksfjgoierwurwd";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            String key = String.valueOf(str.charAt(i));
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                int val = map.get(key);
                map.put(key,val + 1);
            }
        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key+"  ");
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }

    }
}
