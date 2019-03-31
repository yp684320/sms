package day07;
//猜数字游戏(游戏开始,会随机生成一个1--100之间的整数number.玩家猜出第一个数字guessNumber,
// 会与number做比较,系统提示大了或者小了,直到玩家猜中,游戏结束
//创建Random对象
//求出1-100之间的一个随机数字number
//创建Scannery对象
//求出玩家猜的数字
//用while循环,if 语句判断玩家猜的数字与随机数比较,直到猜中,游戏结束

import java.util.Random;
import java.util.Scanner;

public class Demon03Random {
    public static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(100)+1;
        while(true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请玩家输入猜的数字:");
        int guessnumber = sc.nextInt();
            if (guessnumber > number) {
                System.out.println("大了");
            } else if (guessnumber < number) {
                System.out.println("小了");
            } else {
                System.out.println("恭喜您猜中了");
                break;
            }
        }
        System.out.println("游戏结束");
    }
}