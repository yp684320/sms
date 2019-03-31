package hm_01daima;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;

public class DemoServerSocket {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动,等待连接.....");
     //创建服务器流对象
        ServerSocket ss = new ServerSocket(8888);
        //接收连接accept方法
        Socket server = ss.accept();
        //通过socket获取输入流对象
        InputStream is = server.getInputStream();
        //读取数据
        //创建数组
        byte[] b = new byte[1024];
        int len = is.read(b);
        //解析数组  打印字符串信息
        String s = new String (b,0,len);
        System.out.println(s);


        ////////////回写数据///////////
        //通过socket获取输出流对象
        OutputStream os = server.getOutputStream();
        //写出数据
        os.write("我很好,谢谢".getBytes());
        //关闭资源
        os.close();
        is.close();
        server.close();


    }
}
