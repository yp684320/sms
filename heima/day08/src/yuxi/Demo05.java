package yuxi;

import java.util.stream.Stream;

public class Demo05 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌","h","张三","李四");
        //stream.forEach(System.out::println);
       // Stream<String> resullt = stream.filter(s -> s.startsWith("张"));

        //System.out.println(resullt.count());
       // Stream<String> stream1 = stream.limit(3);
        //System.out.println(stream1.count());
        Stream<String> stream2 = stream.skip(2);
        System.out.println(stream2.count());

    }
}
