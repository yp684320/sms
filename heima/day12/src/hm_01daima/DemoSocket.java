package hm_01daima;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class DemoSocket {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建客户端流对象
        Socket socket = new Socket("192.168.18.67",9999);
        //获取输出流对象
        OutputStream os = socket.getOutputStream();
        //写出数据
        os.write("你好".getBytes());


        ////////解析回写////////
        //通过socket获取输入流对象
        InputStream is = socket.getInputStream();
        //读取数据
        byte[] b = new byte[10];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        //关闭资源
        is.close();
        os.close();
        socket.close();


    }

}
