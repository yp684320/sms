package day07;

import java.util.Scanner;

//键盘录入俩个数据并求和
public class Demo01Scanner {
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);
        //接受数据
        System.out.println("请输入第一个数字:");
        int a = sc.nextInt();
        System.out.println("请输入第二个数字:");
       int b = sc.nextInt();
        //对数据进行求和23
        int sum = a + b;
        System.out.println("sum "+sum);
    }
}
