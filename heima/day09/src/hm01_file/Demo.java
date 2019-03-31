package hm01_file;

import java.io.File;

//File类的几种构造方法
public class Demo {
    public static void main(String[] args) {
       //1,public File(String pathname) ：通过将给定的路径名字符串转换为抽象路径名来创建新的File类实例
        //文件路径名
        String pathnam = "D:\\aa.txt";
        File file = new File("D:\\aaa.txt");
        //文件路径名
        String pathname2 = "D:\\aaa\\bbb.txt";
        File file2 = new File("\"D:\\\\aaa\\\\bbb.txt\"");
        //2,public File(String parent, String child) ：从父路径字符串和子路径字符串创建新的File实例
        //文件路径名
        String parent = "d:\\aaa";
        String child = "bbb.txt";
        File file1 = new File(parent, child);
        //3,public File(File parent, String child) ：从父抽象路径和子路径名字符串创建新的File实例
        File file3 = new File(file, child);

    }
}
