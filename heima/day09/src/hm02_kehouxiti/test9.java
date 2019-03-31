package hm02_kehouxiti;

import java.io.File;
import java.util.Scanner;

/*键盘录入一个文件路径，根据文件路径创建文件对象，判断是文件还是文件夹
如果是文件，则输出文件的大小
如果是文件夹，则计算该文件夹下所有文件大小之和并输出(不包含子文件夹)。
*/

public class test9 {
    public static void main(String[] args) {
        //创建Scanner类对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径:");
        //接收数据
        String s = sc.nextLine();
        //创建文件对象
        File f = new File(s);
        //判断是否是文件
        if (f.isFile()) {//是文件
            System.out.println("文件大小为:"+f.length());
        } else {//是文件夹
            int count= 0;//定义变量统计文件大小之和
            File[] f1 = f.listFiles();//获取文件夹下所有文件
            //遍历文件数组
            for (File file : f1) {
                if (file.isFile()) {//是文件
                    long l = file.length();
                    count+= l;
                }

            }
            System.out.println("所有文件夹大小之和为:"+count);
        }
    }
}
