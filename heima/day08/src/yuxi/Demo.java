package yuxi;

import java.util.function.Consumer;

public class Demo {
    private static void ptintString(Consumer<String> data,String str){
        data.accept(str);
    }

    public static void main(String[] args) {
        ptintString(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }, "Hello World");
             ptintString((s)->{
            System.out.println(s);
        },"Hello World");
             ptintString(System.out::println,"Hello World");
    }
}
