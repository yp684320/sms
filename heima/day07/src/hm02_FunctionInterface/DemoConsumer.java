package hm02_FunctionInterface;

import java.util.function.Consumer;

public class DemoConsumer {
    private static void consumerString(Consumer<String> function,String str){
        function.accept(str);
    }

    public static void main(String[] args) {
       consumerString(new Consumer<String>() {
           @Override
           public void accept(String s) {
               System.out.println(s);
           }
       }, "");
       consumerString((String s)-> {
           System.out.println(s);
       },"");
    }

}
