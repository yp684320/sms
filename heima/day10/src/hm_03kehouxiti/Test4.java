package hm_03kehouxiti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*描述:利用字节输入流读取D盘文件a.txt的内容，文件内容确定都为纯ASCII字符
,使用循环读取，一次读取一个字节，直到读取到文件末尾。将读取的字节输出到控制台
*/
public class Test4 {
    public static void main(String[] args) throws IOException {
        //创建字节输入流
        FileInputStream fis = new FileInputStream("d:\\a.txt");
        //定义变量
        int length;
        //循环读取数据
        while ((length = fis.read())!=-1) {
            System.out.println((char)length);
        }
        //关闭资源
        fis.close();
    }
}
