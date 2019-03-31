package hm_03kehouxiti;

import javax.naming.StringRefAddr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*描述:利用字节输入流读取D盘文件b.txt的内容，文件内容确定都为纯ASCII字符
,使用循环读取，一次读取一个字节数组，直到读取到文件末尾，将读取到的字节数组转换成字符串输出到控制台。
*/
public class Test5 {
    public static void main(String[] args) throws IOException {
        //创建字节输入流
        FileInputStream fis = new FileInputStream("d:\\a.txt");
        //定义变量
        int length;
        //创建字节数组
        byte[] b = new byte[1024];
        //循环读取数据
        while ((length = fis.read(b))!= -1) {
            System.out.println(new String(b,0,length));//把数组转换为字符串
        }
        //关闭资源
        fis.close();
    }
}
