package hm_02kehouxiti;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*:利用高效字节输出流往C盘下的d.txt文件输出一个字节数。
*/public class Test {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d.txt"));
        //写出数据
        bos.write(98);
        bos.write(97);
        //关闭资源
        bos.close();

    }
}
