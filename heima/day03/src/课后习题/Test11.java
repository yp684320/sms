package 课后习题;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/*练习十一：LinkedHashSet的使用
十一、键盘录入一个字符串，去掉其中重复字符，打印出不同的那些字符，必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd
*/
public class Test11 {
    public static void main(String[] args) {
        //创建一个Random类
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = sc.next();
        //将字符串转化为字符数组
       char[] chars = s.toCharArray();
        //创建一个LinkedHashSet集合
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        //遍历数组
        for (Character ch : chars) {
            set.add(ch);
        }
       //遍历集合并打印输出
        for (Character a : set) {
            System.out.print(a);
        }





    }
}
