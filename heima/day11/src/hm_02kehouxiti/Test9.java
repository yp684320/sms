package hm_02kehouxiti;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/*描述:从键盘录入一行字符串，利用字节打印流将该行字符串保存到当前项目根目录下的d.txt文件中*/
public class Test9 {
    public static void main(String[] args) throws FileNotFoundException {
        //创建Scanner类对象
        Scanner sc = new Scanner(System.in);
        //输入提示
        System.out.println("请输入一个字符串");
        //接收数据
        String s = sc.next();
        //创建字节打印流对象
        PrintStream ps = new PrintStream("d.txt");
        ps.println(s);
        ps.close();
    }
}
