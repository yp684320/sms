package day07;

import java.util.ArrayList;
import java.util.Random;

//生成6个1-33之间的随机整数,添加到集合并遍历
//创建一个存放整数的集合
//创建Random类
//for循环获取6个数字
//用Random随机生成6个数字
//用add添加到集合
//遍历集合
public class Demon07 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for(int i = 0;i < 6;i++){
            int a = r.nextInt(33)+1;
            list.add(a);
        }
        for(int i = 0;i < list.size();i++){
        System.out.print(list.get(i)+" ");
        }


    }
}
