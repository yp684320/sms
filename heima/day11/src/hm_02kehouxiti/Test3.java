package hm_02kehouxiti;

import java.io.*;

/*描述:利用高效字节输入流和高效字节输出流完成文件的复制。
要求：
1.将C盘下的c.png文件复制到D盘下
2.一次读写一个字节数组方式复制
*/
public class Test3 {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲输入流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\奶爸\\Desktop\\359\\idea基本快捷键.txt"));
        //创建字节缓冲输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a1.txt"));
        //读写数据
        int b ;
        while ((b = bis.read())!= -1) {
            bos.write(b);
        }
        //关闭资源
        bos.close();
        bis.close();
    }
}
