package day07;

import java.util.Random;

//使用Random类,完成生成3个10以内的随机整数
//创建Random对象
//用for循环求出3个数字
//随机生成一个数据
//输出数据
     public class Demon01Random {
    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0 ;i < 3;i++){
            int a = r.nextInt(10);
            System.out.println(a);
        }
    }
}
