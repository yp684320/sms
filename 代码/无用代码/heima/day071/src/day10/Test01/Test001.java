package day10.Test01;

import java.util.Random;
import java.util.Scanner;

public class Test001 {
    public static void main(String[] args){
    //创建Random类
        Random r = new Random();
        int b = r.nextInt(11) +50;
        //创建Scanner类
        Scanner sc = new Scanner(System.in);
       while(true) {
           System.out.println("请输入一个数字");
           int c = sc.nextInt();
            if (c > b) {
                System.out.println("大了");
            }
            else if(c < b){
                System.out.println("小了");
            }
            else if(c==b){
                System.out.println("恭喜你,猜中了");
                break;
            }

        }
    }
}
