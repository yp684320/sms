package yuxi;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/*map：映射
如果需要将流中的元素映射到另一个流中，可以使用 map 方法。方法签名：
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
该接口需要一个 Function 函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
*/
public class Demo07 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("10","20","30","40");
       /* stream.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        stream.map(  Integer::parseInt);*/
        Stream<Integer> result = stream.map(  Integer::parseInt);
        /*result.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/
        result.forEach(System.out::println);
    }
}
