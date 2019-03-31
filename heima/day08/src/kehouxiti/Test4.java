package kehouxiti;

import java.util.ArrayList;
import java.util.stream.Stream;

/*	练习六：映射：map、逐一消费：forEach
问题：
有如下整数1，-2，-3，4，-5
使用Stream取元素绝对值并打印
*/
public class Test4 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-2);
        list.add(-3);
        list.add(4);
        list.add(-5);
        Stream<Integer> stream1 = Stream.of(1, -2, -3, 4, -5);
        //获取流
        Stream<Integer> stream = list.stream();
        stream.map(Math::abs).forEach(System.out::println);

    }
}
