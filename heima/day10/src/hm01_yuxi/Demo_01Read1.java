package hm01_yuxi;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo_01Read1 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileInputStream f = new FileInputStream("d:\\read.txt");
        //定义变量  保存数据
        int b ;
        while ((b = f.read()) != -1) {
            System.out.println((char)b);
        }
        //关闭资源
        f.close();;
      // 1. 虽然读取了一个字节，但是会自动提升为int类型。
        //2. 流操作完毕后，必须释放系统资源，调用close方法，千万记得。
    }
}
