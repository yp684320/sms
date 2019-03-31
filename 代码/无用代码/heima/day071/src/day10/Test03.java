package day10;

import java.util.ArrayList;

/*1.字符串数组strs中包含字符串{"Mini","98k","6789","Groza","AWM","5.56"}，
2.创建2个ArrayList集合，遍历strs数组，并判断数组中每一个元素的长度.
将长度为偶数的元素和长度为奇数的元素分别存放在两个集合中，最终将这两个集合在控制台打印：*/
public class Test03 {
    public static void main(String[] args) {
//1.字符串数组strs中包含字符串{"Mini","98k","6789","Groza","AWM","5.56"}，
        String[] strs = {"Mini","98k","6789","Groza","AWM","5.56"};
        //创建集合
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        //遍历数组
        for (int i = 0;i < strs.length;i ++){
            if(strs[i].length() % 2 == 0){
                list1.add(strs[i]);
            }
            else {
                list2.add(strs[i]);
            }
        }
        System.out.println(list1);
        System.out.println(list2);

    }
}
