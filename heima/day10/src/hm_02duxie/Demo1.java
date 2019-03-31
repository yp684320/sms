package hm_02duxie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//复制
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("C:\\Users\\奶爸\\Desktop\\359\\123.jpg");
        //创建输出流对象
        FileOutputStream fos = new FileOutputStream("out1.jpg");
        //读取数据
        //定义变量
        int length;
        //循环读取
        while ((length = fis.read())!= -1) {
            fos.write((char)length);
        }
        //关闭资源
        fos.close();
        fis.close();

    }
}
