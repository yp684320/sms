package hm_03kehouxiti;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/*练习二:字节输出流写出数据
描述:
从控制台循环接收用户录入的学生信息，输入格式为：学号-学生名字
将学生信息保存到D盘下面的stu.txt文件中，一个学生信息占据一行数据。
当用户输入end时停止输入。
*/
public class Test2_kuozhan {
    public static void main(String[] args) throws IOException {
        //创建字符输出流对象
        FileWriter fw = new FileWriter("stu.txt");
        //创建Scanner类对象
        Scanner sc = new Scanner(System.in);
        while (true) {
            //输入提示
            System.out.println("请输入学生信息格式为(学号-学生姓名):");
            //接受数据
            String s = sc.nextLine();
            fw.write(s);
           fw.write("\r\n");
            if (s.equals("end")) {
                break;
            }
        }
       fw.close();
    }
}
