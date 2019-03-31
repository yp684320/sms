package hm_02duxie;

import java.io.*;

//复制文档,用字符流
public class Demo2 {
    public static void main(String[] args) throws IOException {
        //创建流对象
        //创建输入流对象
        FileReader fr = new FileReader("D:\\2018java基础班\\(2).txt");
        //创建输出流对象
        FileWriter fw = new FileWriter("writer.txt");
        //读取数据
        //定义变量
        int length;
        //创建数组
        char[] ch = new char[1024];
        //循环读取数据
        while ((length = fr.read(ch))!= -1) {
           // fw.write(ch);
            fw.write(ch,0,length);
        }
        //关闭资源
        fw.close();
        fr.close();

    }
}
