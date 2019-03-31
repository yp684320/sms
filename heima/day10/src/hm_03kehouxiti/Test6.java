package hm_03kehouxiti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*描述:利用字节流将E盘下的a.png图片复制到D盘下(文件名保存一致)
要求：
一次读写一个字节的方式
*/
public class Test6 {
    public static void main(String[] args) throws IOException {
        //创建字节流对象
        //创建输入流对象
        FileInputStream fis = new FileInputStream("C:\\Users\\奶爸\\Desktop\\359\\123.jpg");
        //创建输出流对象
        FileOutputStream fos = new FileOutputStream("123.jpg");
        //定义变量
        int length;
        //循环读取
        while ((length = fis.read())!= -1) {
            fos.write(length);
        }
        //关闭资源
        fos.close();
        fis.close();

    }
}
