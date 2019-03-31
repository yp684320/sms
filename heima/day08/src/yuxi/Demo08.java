package yuxi;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo08 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("汽车");
        list.add("飞机");
        list.add("小火车");
        list.add("小自行车");
        list.add("小汽车");
        list.add("小玩具车");
        //获取流
        Stream<String> stream = list.stream();
        //过滤
       /* stream.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("小");
            }
        });*/
       // Stream<String> stream1 = stream.filter(s -> s.startsWith("小")).filter(s -> s.length()==3).limit(2).skip(1);
        stream.filter(s -> s.startsWith("小")).filter(s -> s.length()==3).limit(2).skip(1).forEach(System.out::println);

    }


}
