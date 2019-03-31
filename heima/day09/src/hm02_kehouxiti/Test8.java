package hm02_kehouxiti;

import java.io.File;

/*获取指定文件夹下所有的文件，并将所有文件的名字输出到控制台。
注意：不包含子文件夹下的文件

public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
*/
public class Test8 {
    public static void main(String[] args) {
        //创建一个文件对象
        File f = new File("D:\\2018java基础班");
       //获取文件夹下的所有文件
        File[] f1 = f.listFiles();
        //遍历输出
        for (File file : f1) {
            System.out.println(file);
        }
    }
}
