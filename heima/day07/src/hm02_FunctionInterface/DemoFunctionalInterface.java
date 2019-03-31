package hm02_FunctionInterface;

public class DemoFunctionalInterface {
    //使用自定义的函数式接口作为方法参数
    public static void doSomething(MyFunctionalIiterface inter){
        inter.myWethod();//调用自定义的函数式接口方法
    }

    public static void main(String[] args) {
        //调用使用函数式接口的方法
        doSomething(new MyFunctionalIiterface() {
            @Override
            public void myWethod() {
                System.out.println("Lambda执行啦");
            }
        });//调用使用函数式接口的方法
        doSomething(() ->System.out.println("Lambda执行啦"));
    }
}
