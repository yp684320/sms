package hm02_FunctionInterface;

import java.util.function.Function;

public class DemoFunction {
    private static void method(Function<String,Integer> function,String str){
        int num = function.apply(str);
        System.out.println(num+20);
    }

    public static void main(String[] args) {
        method(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                int a = Integer.parseInt(s);
                return a;
            }
        }, "10");
       method((String s)->{int a = Integer.parseInt(s);return a;},"");
        method( s-> Integer.parseInt(s),"");
    }
}
