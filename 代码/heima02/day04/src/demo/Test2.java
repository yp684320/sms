package demo;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(2,new User("张三",20));
        users.put(1,new User("李四",21));
        users.put(3,new User("王五",22));
        System.out.println(users);
        HashMap<Integer, User> map = sortHashMap(users);
        System.out.println(map);
    }
    public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> map){
        // 首先拿到map的键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();
        // 将set转换为list集合
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);
//        使用collections集合工具类对list进行排序,排序规则使用匿名内部类来实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                // 按照要求根据user的age进行倒序排序
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });
        // 创建一个新的有序的HashMap的子类集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        // 将list中的数据存在linkedHashMap中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        // 返回结果
        return linkedHashMap;

    }
}
