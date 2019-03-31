package kehouxiti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*简述单列集合、双列集合、数组分别如何获取Stream流对象，并进行演示*/
public class Test3 {
    public static void main(String[] args) {
        //单列集合获取流
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张翠山");
        list.add("张强");
        list.add("赵敏");
        list.add("欧阳大侠");
        list.add("张三丰");
        Stream<String> stream = list.stream();
        stream.filter(s -> s.startsWith("张")).filter(s -> s.length()==3).limit(3).skip(1).forEach(System.out::println);
        System.out.println("==============");
        //双列集合获取流
        HashMap<String, Integer> map = new HashMap<>();
        map.put("张无忌",34);
        map.put("张翠山",38);
        map.put("张强",36);
        map.put("赵敏",33);
        map.put("欧阳大侠",44);
        map.put("张三丰",39);
        //获取key流
        Stream<String> stream1 = map.keySet().stream();
        stream1.filter(s -> s.startsWith("张")).limit(3).skip(1).forEach(System.out::println);
        //获取values流
        Stream<Integer> stream2 = map.values().stream();
        //获取entrySe流
        Stream<Map.Entry<String, Integer>> stream3 = map.entrySet().stream();
        //获取数组流
       // String[] arr = {"东邪", "西毒", "南帝", "北丐", "中神通"};
        Stream<String> stream4 = Stream.of("东邪", "西毒", "南帝", "北丐", "中神通");
        String[] strings = stream4.filter(s -> s.length() == 2).toArray(String[]::new);
        for (String s : strings) {
            System.out.println(s);
        }


    }
}
