package day07;

import java.util.Scanner;

//键盘录入三个数据并求出最大值
//创建键盘录入对象
//接受数据
//求出三个数字中的最大值
//用三元运算符

public class Demon02Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字 ");
        int a = sc.nextInt();
        System.out.println("请输入第二个数字 ");
        int b = sc.nextInt();
        System.out.println("请输入第三个数字 ");
        int c = sc.nextInt();
        //三元运算符求最大值
        int max = (a > b)?(a > c? a: c):(b > c? b : c);
        System.out.println("三个数字中的最大值是:"+max);

    }
}
