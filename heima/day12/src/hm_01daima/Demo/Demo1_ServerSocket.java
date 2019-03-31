package hm_01daima.Demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_ServerSocket {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动....");
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //接收连接 accept 方法, 返回 socket 对象.
        Socket accept = serverSocket.accept();
        //创建输入流对象
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        //创建输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("123.jpg"));
        //读写数据
        int len;
        byte[] b = new byte[1024];
        while ((len = bis.read(b))!=-1) {
            bos.write(b,0,len);
        }
        //关闭资源
        bos.close();
        bis.close();
        ////////回写数据////
        //获取输出流对象
        OutputStream outputStream = accept.getOutputStream();
    }
}
