package Test;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串");
        Scanner sc = new Scanner(System.in);
        String  d = sc.nextLine();
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < d.length(); i++) {
            if(d.charAt(i) >= 'A' && d.charAt(i)<='Z'){
                a++;
            }else if (d.charAt(i) >= '0' && d.charAt(i) <='9' ){
                b++;

            }else{
                c++;
            }

        }
        System.out.println("英文字母个数:"+a);
        System.out.println("数字个数:"+b);
        System.out.println("其他字符个数:"+c);
    }
}
