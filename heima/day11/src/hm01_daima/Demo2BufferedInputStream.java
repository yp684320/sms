package hm01_daima;

import java.io.*;

public class Demo2BufferedInputStream {
    public static void main(String[] args) throws IOException {
        //记录开始时间
        long start = System.currentTimeMillis();
        //创建字节缓冲输入流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\develop\\java\\bin\\java.exe"));
        //创建字节缓冲输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("java.exe"));
        //读写数据
        int len;
        byte[] b = new byte[1024];
        while ((len = bis.read(b))!= -1) {
            bos.write(b);
        }
        //关闭资源
        bos.close();
        bis.close();
        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("字节缓冲流复制时间是"+(end - start)+"毫秒");
    }
}
