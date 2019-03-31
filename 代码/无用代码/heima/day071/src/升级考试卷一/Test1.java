package 升级考试卷一;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符串");
        Scanner sc = new Scanner(System.in);
        //定义以个自非常并赋值为空
        String s = sc.nextLine();
        //定义变量统计英文字母,数字,其他字符
       int a = 0;
        int b = 0;
        int c = 0;
        //遍历字符串,并统计个数
        for (int i = 0;i < s.length();i ++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'||s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                a++;
            }
            else  if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                b++;
            }
            else{
               c++;
            }
        }
        System.out.println("英文字母个数:"+a);
        System.out.println("数字个数:"+b);
        System.out.println("其他字符个数:"+c);


    }
}
