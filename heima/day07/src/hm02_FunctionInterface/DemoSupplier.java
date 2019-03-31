package hm02_FunctionInterface;

import java.util.function.Supplier;

public class DemoSupplier {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 45, 6, 777};
        //调用使用函数式接口的方法
        printMax(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int max = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > arr[0]) {
                        max = arr[i];
                    }
                }
                return max;
            }
        });
        printMax(() -> {
                    int max = arr[0];
                    for (int i = 1; i < arr.length; i++) {
                        if (arr[i] > arr[0]) {
                            max = arr[i];
                        }
                    }
                    return max;
                }
        );
        printMax(() -> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[0]) {
                    max = arr[i];
                }
            }
            return max;
        });
    }


    //使用自定义的函数式接口作为参数
    private static void printMax(Supplier<Integer> supplier){
        //调用自定义函数式接口的方法
        int max = supplier.get();
        System.out.println(max);

    }
}
