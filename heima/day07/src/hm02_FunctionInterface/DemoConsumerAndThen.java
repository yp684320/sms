package hm02_FunctionInterface;

import java.util.function.Consumer;

public class DemoConsumerAndThen {
    private static void consumerString(Consumer<String> one ,Consumer<String> two,String str){
        one.andThen(two).accept(str);
    }

    public static void main(String[] args) {
        consumerString(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        }, new Consumer<String>() {
            @Override
            public void accept(String s) {
                s.toLowerCase();
            }
        }, "heLlo");

        consumerString((String s)->{
            System.out.println(s.toUpperCase());
        },
        (String s)->{
            System.out.println(s.toLowerCase());
        },"heLlo");
    }
}
