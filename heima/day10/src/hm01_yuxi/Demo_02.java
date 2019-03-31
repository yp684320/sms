package hm01_yuxi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/*使用字节数组读取： read(byte[] b) ，每次读取b的长度个字节到数组中，
返回读取到的有效字节个数，读
取到末尾时，返回 -1 ，*/
public class Demo_02 {
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("D:\\read.txt");
        fileWriter.write("aaaa aaaa aaaa aaaa aa");
        fileWriter.close();
        //使用文件名创建流对象
        FileInputStream f = new FileInputStream("read.txt");
        //定义统计变量 作为有效个数
        int len ;
        //定义字节数组 作为装字节数组的容器
        byte[] b = new byte[4];// 0 1 2 3
        //循环读取
//        while ((len = f.read(b))!= -1) {
//            System.out.println(new String(b));
//
        while ((len = f.read(b))!=-1) {
            System.out.println(new String(b,0,len));//3    1 2 3
            System.out.println(len);
        }
        //关闭资源
        f.close();
    }
}
