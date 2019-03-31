package hm01_yuxi;

import java.io.FileWriter;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileWriter fw = new FileWriter("d:\\fw.txt",true);
        //字符串转换为字符
        char[] chars = "黑马程序员".toCharArray();
        //写出字符数组
         fw.write(chars);
         fw.write("\r\n");
         fw.write(chars,2,2);
         fw.close();

                ;
    }
}
