package day08;

import java.util.Scanner;

/*- 模拟简单计算器，可以运算+，—，*，/，%。
  - 接收三个参数，一个整数，一个运算符，另一个整数。
  - 计算出运算结果。
  - 无法运算时，返回null。
- 代码实现，效果如图所示：
*/
public class Test06 {
    public static void main(String[] args) {
        //创建Scanner类,并接受数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int a = sc.nextInt();
        System.out.println("请输入一个运算符:");
        String b = sc.next();
        System.out.println("请输入一个整数:");
        int c = sc.nextInt();
        String get= get(a,b,c);//调用方法
        System.out.println(a + b + c +"="+ get);//打印结果
    }

    public static String get(int a, String b, int c) {
        //定义一个计数器
        int r = 0;
        if ("+".equals(b)) {
            r = a + c;
        } else if ("-".equals(b)) {
            r = a - c;
        } else if ("*".equals(b)) {
            r = a * c;
        } else if ("/".equals(b)) {
            r = a / c;
        } else if ("%".equals(b)) {
            r = a % c;
        } else {
            return null;
        }
        return r+" ";
    }
}