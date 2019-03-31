package hm02_kehouxiti;


import java.io.File;

/*获取文件信息:文件名,文件大小,文件的绝对路径,文件的父路径*/
public class Test6 {
    public static void main(String[] args) {
        //创建File类对象
        File file = new File("d:aaa\\bbb\\c.txt");
        //获取文件名
        System.out.println("文件名称:"+file.getName());
        System.out.println("文件大小是:"+file.length());
        System.out.println("文件的绝对路径:"+file.getAbsolutePath());
        System.out.println("文件的父路径:"+file.getParent());
        //获取父类文件夹路径  返回文件对象
        System.out.println("文件父路径:"+file.getParentFile());

    }
}
