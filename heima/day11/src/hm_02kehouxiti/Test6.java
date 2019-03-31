package hm_02kehouxiti;

import java.io.*;

/*描述:利用转换输入流将当前项目根目录下使用gbk编码的a.txt文件的内容读取出来，并打印在控制台上。
要求：不能出现乱码的情况。
*/
public class Test6 {
    public static void main(String[] args) throws IOException {
        //创建字符转换输入流
        InputStreamReader r = new InputStreamReader(new FileInputStream("a.txt"),"gbk");
       int read;
        while ((read = r.read())!=-1) {
            System.out.print((char)read);
        }
        r.close();


    }
}
