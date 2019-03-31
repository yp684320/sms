package hm01_file;

import java.io.File;

/*3 常用方法
获取功能的方法
public String getAbsolutePath() ：返回此File的绝对路径名字符串。
public String getPath() ：将此File转换为路径名字符串。
public String getName() ：返回由此File表示的文件或目录的名称。
public long length() ：返回由此File表示的文件的长度。
API中说明：length()，表示文件的长度。但是File对象表示目录，则返回值未指定

public boolean exists() ：此File表示的文件或目录是否实际存在。
public boolean isDirectory() ：此File表示的是否为目录。
public boolean isFile() ：此File表示的是否为文件。*/
public class Demo2 {
    public static void main(String[] args) {
        //创建File类
        File file = new File("d:\\aaa\\bbb.java");
        System.out.println("文件绝对路径:"+file.getAbsolutePath());
        System.out.println("文件构造路径:"+file.getPath());
        System.out.println("文件名称:"+file.getName());
        System.out.println("文件长度:"+file.length());

        File file1 = new File("d:\\aaa");
        System.out.println("目录绝对路径:"+file1.getAbsolutePath());
        System.out.println("目录构造路径:"+file1.getPath());
        System.out.println("目录名称:"+file1.getName());
        System.out.println("目录长度:"+file1.length());

        //*public boolean exists() ：此File表示的文件或目录是否实际存在。
        //public boolean isDirectory() ：此File表示的是否为目录。
        //public boolean isFile() ：此File表示的是否为文件。*/
        System.out.println("d:\\aaa\\bbb.java是否存在"+file.exists());
        System.out.println("d:\\aaa\\bbb.java文件?"+file.isFile());
        System.out.println("d:\\aaa\\bbb.java目录?"+file.isDirectory());
        System.out.println("d:\\aaa文件是否存在"+file1.exists());
        System.out.println("d:\\aaa文件?"+file1.isFile());
        System.out.println("d:\\aaa目录?"+file1.isDirectory());

    }
}
