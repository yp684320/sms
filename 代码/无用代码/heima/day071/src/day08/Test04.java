package day08;

import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        //创建一个字符串数组,存放"奥巴马","普京"
        String [] arr = {"奥巴马","普京"};
        //创建Scanner类并接受
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s = sc.nextLine();
        //遍历数组arr
        for(int i = 0;i < arr.length; i ++){
        s= s.replace(arr[i],"*");

        }
        System.out.println(s);

    }

}
