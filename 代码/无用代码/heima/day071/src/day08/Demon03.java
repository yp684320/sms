package day08;

import java.util.Scanner;

//键盘录入一个字符串,统计字符串中的字母大小写的个数和数字的个数
/*1,创建Scanner对象,并接受数据
2,定义统计变量,计算大小写字母的个数和数字个数
3,遍历字符串,得到不同的字符
4,用if语句判断
*/
public class Demon03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = sc.nextLine();
        int bignum = 0;
        int smallnum = 0;
        int othernum =0;
        for (int a = 0;a < s.length();a++) {
            char ch = s.charAt(a);
            if (ch >= 'A' && ch <= 'Z'){
                bignum++;
            } else if(ch >= 'a'&& ch <= 'z'){
                smallnum++;
            }else if(othernum >= 0 && othernum <= 9){
                othernum++;
            }else{
                System.out.println("该字符:"+ch+"非法");
            }
        }
        System.out.println("大写字母的个数:"+ bignum +"个");
        System.out.println("小写字母的个数:"+ smallnum +"个");
        System.out.println("数字个数:"+ othernum +"个");

    }
}
