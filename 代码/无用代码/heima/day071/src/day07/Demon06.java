package day07;

import java.util.ArrayList;

//ArrayList存储基本类型的格式
public class Demon06 {
    public static void main(String[] args) {
        //创建ArrayList类对象
       /*ArrayList<Byte> list = new ArrayList<>();
        list.add((byte)1);byte类输入数字需要强制转换,因为数字默认为int类型
        list.add((byte)0);
        list.add((byte)6);*/
       ArrayList<Integer> list = new ArrayList<>();
       list.add(4);
       list.add(5);
       list.add(7);
        System.out.println(list);
    }
}
