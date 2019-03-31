package hm_02duxie;

import java.io.FileWriter;
import java.io.IOException;

//使用字符流写出数据
public class Demo3 {
    public static void main(String[] args) throws IOException {
        //创建字符流对象
        FileWriter fw = new FileWriter("out2.txt",true);
        //写出字符： write(int b) 方法，每次可以写出一个字符数据
        fw.write(97);
        fw.write(98);
        fw.write("\r\n");
        fw.write('a');
        fw.write("" + "黑马程序员");
        //创建字符数组
        char[] ch = "哈哈,黑马程序员".toCharArray();
        fw.write(ch);
        fw.write("\r\n");
        fw.write(ch,3,2);

        //关闭资源
        fw.close();
    }

}
