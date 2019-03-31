package kehouxiti;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*	练习七：组合：concat、结果收集(list)
问题：
已知数组arr1中有如下元素{郭靖，杨康}，arr2中有如下元素{黄蓉，穆念慈}，使用Stream将二者合并到List集合
*/
public class Test5 {
    public static void main(String[] args) {
        String[] arr1 = {"郭靖","杨康"};
        String[] arr2 = {"黄蓉","穆念慈"};
        //获取数组arr1和arr2的流
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        Stream<String> stream = Stream.concat(stream1, stream2);
       // List<String> list = stream.collect(Collectors.toList());//public static <T> Collector<T, ?, List<T>> toList() ：转换为 List 集合。
        //Set<String> set = stream.collect(Collectors.toSet());// public static <T> Collector<T, ?, Set<T>> toSet() ：转换为 Set 集合。
        Object[] array = stream.toArray();//Object[] toArray();收集到数组中
        for (Object o : array) {
            System.out.println(o);
        }
       // System.out.println(list);

    }
}
