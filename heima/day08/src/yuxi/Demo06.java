package yuxi;
/*Function接口
java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，
后者称为后置条件。有进有出，所以称为“函数Function”。
抽象方法：apply
Function 接口中最主要的抽象方法为： R apply(T t) ，根据类型T的参数获取类型R的结果。使用的场景例如：
将 String 类型转换为 Integer 类型。*/
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo06 {
    public static void main(String[] args) {
        method(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        },"");

    }
    private static void method(Function<String, Integer> function, String str) {
        int num = function.apply(str);
        System.out.println(num + 20);
    }


}
