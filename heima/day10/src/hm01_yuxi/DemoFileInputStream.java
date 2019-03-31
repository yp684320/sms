package hm01_yuxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoFileInputStream {
    public static void main(String[] args) throws IOException {
        //使用File对象创建流对象
        File file = new File("a.txt");
        FileInputStream fos = new FileInputStream(file);
        //使用文件名称创建流对象
        FileInputStream fos1 = new FileInputStream("b.txt");
    }
}
