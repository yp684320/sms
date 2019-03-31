package hm01_yuxi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*read 方法，每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回 -1*/
public class Demo01_Read {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileInputStream f = new FileInputStream("d:\\read.txt");
        //读取数据
        int read = f.read();
        System.out.println((char) read);
        read = f.read();
        System.out.println((char) read);
        read = f.read();
        System.out.println((char) read);
        read = f.read();
        System.out.println((char) read);
        read = f.read();
        System.out.println((char) read);
        read = f.read();
        System.out.println((char) read);
        //读取到末尾,返回-1
        read = f.read();
        System.out.println( read);
        //关闭资源
        f.close();


    }
}
