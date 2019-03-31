package day11.Test1;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String s = "23.456389";
        System.out.println("原数字字符串:" + s);
        //创建一个实现类
        HandleAble s1 = new HandleAble() {
            @Override
            public String handleString(String s) {
                return s.substring(0, s.indexOf("."));
            }
        };
        String string = s1.handleString(s);
        System.out.println("取整后:" + string);

        //创建一个Scanner类
        Scanner sc = new Scanner(System .in);
        int num = sc.nextInt();
       // int num = new Scanner(System.in).nextInt(); // 假设录入4
       HandleAble s2 = new HandleAble() {
           @Override
           public String handleString(String s) {
               int i = s.indexOf(".")+ num +1;
               char c = s.charAt(i);
               if (c <= 4){
                   return s.substring(0,i);
               }else{
                   char c1 = (char)(s.charAt(s.indexOf(".")+num)+1);
                   return s.substring(0,i-1) + c1;
               }
           }
       };
        String sss = s2.handleString(s);
        System.out.println("保留" + num + "位小数后:" + sss);
    }
}