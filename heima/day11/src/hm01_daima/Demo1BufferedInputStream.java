package hm01_daima;

import java.io.*;

/*效率测试
* 1,记录开始时间
* 2,创建流对象
* 3,读写数据
* 4,关闭资源
* 5,记录结束时间*/
public class Demo1BufferedInputStream {
    public static void main(String[] args) throws IOException {
       //记录开始时间
       long start = System.currentTimeMillis();
       //创建缓冲输入流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\develop\\java\\bin\\java.exe"));
        //创建缓冲输出轮流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("javaw.exe"));
        //读写数据
        int b ;
        while ((b = bis.read())!= -1) {
            bos.write(b);
        }
        //关闭资源
        bos.close();
        bis.close();
        //记录时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流复制时间是"+(end - start)+"毫秒");
    }
}
