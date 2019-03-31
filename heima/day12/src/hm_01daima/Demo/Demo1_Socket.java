package hm_01daima.Demo;

import java.io.*;
import java.net.Socket;

/*文件上传分析图解
1. 【客户端】输入流，从硬盘读取文件数据到程序中。
2. 【客户端】输出流，写出文件数据到服务端。
3. 【服务端】输入流，读取文件数据到服务端程序。
4. 【服务端】输出流，写出文件数据到服务器硬盘中。
5. 【服务端】获取输出流，回写数据。
6. 【客户端】获取输入流，解析回写数据。*/
public class Demo1_Socket {
    public static void main(String[] args) throws IOException {

        //创建输入流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\奶爸\\Desktop\\359\\123.jpg"));
        //创建输出流对象  写到服务器
        Socket socket = new Socket("localhost", 8888);
        //通过socket获取输出流对象
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        //读写数据
        int len;
        byte[] b = new byte[1024];
        while ((len = bis.read(b))!=-1) {
            bos.write(b,0,len);
        }
        //关闭输出流  通知服务器 写出完毕
        socket.shutdownInput();
        System.out.println("文件发送完毕");
        //关闭资源
        bos.close();
        bis.close();


    }
}
