package day08;

import java.util.Scanner;

//- 反转键盘录入的字符串。
//- 代码实现，效果如图所示：
//
//- 开发提示：
//  - 使用字符数组保存原始字符.
/*1.创建Scanner类,并接受数据
2,创建一个字符串
3,反转字符串,先转换为字符数组,再遍历字符串
*/
public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String a = sc.next();
        System.out.println("录入的字符串:"+a);
        String s = reversestr(a);
        System.out.println("录入的字符串:"+s);
    }
    public static String reversestr(String a){
        String s = "";
        char[] ch = a.toCharArray();
        for(int i = ch.length-1;i >= 0;i--){
            s += ch[i];
        }
        return s;
    }
}

