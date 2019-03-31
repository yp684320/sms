package hm_03kehouxiti;

import java.io.*;

/*描述:在D盘下，有一c.txt 文件中内容为：HelloWorld
在c.txt文件原内容基础上，添加五句 I love java，而且要实现一句一行操作(注：原文不可覆盖)。
利用字节输出流对象往C盘下c.txt文件输出5句：”i love java”
*/
public class Test3 {
    public static void main(String[] args) throws IOException {
        //创建字节流对象
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("d:\\c.txt");
        //创建字符输出流
        FileWriter fw = new FileWriter("d:\\c.txt",true);
        //读取数据
        //定义变量
        int len;
        //循环读取
        while ((len = fis.read())!= -1) {
            System.out.print((char)len);
        }
       //创建字符数组
        char[] ch = "I love java".toCharArray();
        //输出换行
        fw.write("\r\n");
        //写出数据
        fw.write(ch);
        //创建字节输出流
        FileOutputStream fos = new FileOutputStream("d:\\d.txt");
        //输出数据
        String s = "i love java \r\n";
        for (int i = 0; i < 5; i++) {
            fos.write(s.getBytes());//把字符串转换为字符数组
        }
        fos.close();
        //关闭资源
        fw.close();
        fis.close();





    }
}
