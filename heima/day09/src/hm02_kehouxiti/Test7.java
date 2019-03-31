package hm02_kehouxiti;

import java.io.File;

/*1.判断File对象是否是文件,是文件则输出：
xxx是一个文件，否则输出：xxx不是一个文件。
2.判断File对象是否是文件夹,是文件夹则输出：
xxx是一个文件夹，否则输出：xxx不是一个文件夹。(xxx是文件名或文件夹名)
*/
public class Test7 {
    public static void main(String[] args) {
        //创建文件对象
        File f1 = new File("d:\\a.txt");
        //判断是否是一个文件夹
        if (f1.isFile()) {
            System.out.println(f1.getName()+"是一个文件");

        }else{
            System.out.println(f1.getName()+"不是一个文件");
        }
        f1.delete();
        //创建文件对象
        File f2= new File("d:\\aaa");
        //判断是否是一个文件
        if (f2.isDirectory()) {
            System.out.println(f2.getName() + "是一个文件夹");
        } else {
            System.out.println(f2.getName()+"不是一个文件夹");
        }
        f2.delete();

    }
}
