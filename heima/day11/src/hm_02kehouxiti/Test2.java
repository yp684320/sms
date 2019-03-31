package hm_02kehouxiti;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*利用高效字节输出流往C盘下的e.txt文件写出一个字节数组数据，如写出：”i love java”*/
public class Test2 {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e.txt"));
        //写出数据
       bos.write("i love java".getBytes());
       //关闭资源
        bos.close();

    }
}
