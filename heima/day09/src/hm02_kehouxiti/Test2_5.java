package hm02_kehouxiti;

import java.io.File;
import java.io.IOException;

public class Test2_5 {
    public static void main(String[] args) throws IOException {
        //创建File类对象
        File file = new File("d:a.txt");
        //检查D盘下是否存在文件a.txt,如果不存在则创建该文件。
        if (!file.exists()) {
            file.createNewFile();
        }
        //:在D盘下创建一个名为bbb的文件夹
        //创建文件对象
        File file1 = new File("d:bbb");
        //创建单级文件
        file1.mkdir();
         //述:在D盘下创建一个名为ccc的文件夹，要求如下：
         //1.ccc文件夹中要求包含bbb子文件夹
        // 2.bbb子文件夹要求包含aaa文件夹
        //创建文件对象
        File file2 = new File("d:ccc\\bbb\\aaa");
        //创建多级文件
        file2.mkdirs();
         //将D盘下a.txt文件删除
        //将D盘下aaa文件夹删除,要求文件夹aaa是一个空文件夹。
        //创建文件对象
        File file3 = new File("D:\\a.txt");
        //删除文件
        file3.delete();
         //创建多级文件
        File dir = new File("D:\\aaa");
        dir.delete();




    }
}
