package hm_02duxie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        //创建输入流对象
        FileInputStream fis = new FileInputStream("C:\\Users\\奶爸\\Desktop\\359\\123.jpg");
        //创建输出流对象
        FileOutputStream fos = new FileOutputStream("out.jpg");
        //读写数据
        //定义变量
        int length;
        //定义数组
        byte[] bytes = new byte[1024];
        //循环读取
        while ((length = fis.read(bytes))!= -1) {
            fos.write(bytes,0,length);
        }
        //关闭资源  原则:先开后关  后开先关
        fos.close();
        fis.close();
    }
}
