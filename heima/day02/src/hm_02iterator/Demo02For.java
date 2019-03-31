package hm_02iterator;

import java.util.ArrayList;
import java.util.Collection;

/* 
它用于遍历Collection和数组。通常只进行遍历元素，
不要在遍历的过程中对集合元素进行增删操作。
代码演示
 
for(元素的数据类型  变量 : Collection集合or数组){     //写操作代码 } 
* */
public class Demo02For {
    public static void main(String[] args) {
        int[] arr = {3,5,67,7,8};
        //使用增强for遍历数组
        for(int i :arr){//i是变量,代表数组中的每个元素
            System.out.print(i+" ");

        }
        System.out.println("=====");
        Collection<String> coll = new ArrayList<String>();
        coll.add("哈哈哈");
        coll.add("刚刚");
        coll.add("有意义");
        for(String s: coll){
            System.out.println(s);
        }
    }

}
