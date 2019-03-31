package hm03_kehouxiti;
/*给定一个计算器 Calculator 接口，内含抽象方法 calc (减法)，
其功能是可以将两个数字进行相减，并返回差值。使用Lambda表达式在Test中完成调用。*/
public class Test10 {
    public static void main(String[] args) {
        invokeCalc(130, 120, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a-b;

            }
        });
        invokeCalc(130,120,(a,b)->{return a-b;});
        invokeCalc(130,120,(a,b)->a-b);

    }
    private static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }
}


