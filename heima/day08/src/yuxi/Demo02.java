package yuxi;
/*
对象名--引用成员方法
这是常见的一种用法，与上例相同。
如果一个类中已经存在了一个成员方法，则可以通过对象名引用成员方法， 代码为*/
import java.util.function.Supplier;

public class Demo02 {
    private static void pintUp(Supplier<String> sup){
        String apply = sup.get();
        System.out.println(apply);

    }

    public static void main(String[] args) {
        String s = "Hello";
        pintUp(s ::toUpperCase);
        pintUp(new Supplier<String>() {
            @Override
            public String get() {
                String str= s.toLowerCase();
                System.out.println(str);
                return str;
            }
        });
    }
}
