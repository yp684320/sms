package hm_03kehouxiti;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*项目需求：请用户从控制台输入信息，程序将信息存储到文件Info.txt中。
可以输入多条信息，每条信息存储一行。当用户输入：”886”时，程序结束。*/
public class Test7 {
    public static void main(String[] args) throws IOException {
        //创建Scanner类对象
        Scanner sc = new Scanner(System.in);
        //创建字符输出流对象
        FileWriter fw = new FileWriter("Info.txt");
        while (true) {
            System.out.println("请您输入信息:");
            //接受数据
            String s = sc.nextLine();
            if (s.equals("886")) {
                System.out.println("程序结束");
                break;

            } else {
                fw.write(s);
                fw.write("\r\n");
            }
        }
        fw.close();
    }
}
