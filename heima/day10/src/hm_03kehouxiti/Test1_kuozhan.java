package hm_03kehouxiti;

import java.io.*;

/*练习一:字节输入流使用
描述:
在D盘下有一个文本文件test.txt(里面的内容由数字和字母组成)
定义一个方法统计test.txt文件中’a’字符出现的次数。
比如a字符在文件中出现了10次则调用方法传入a后，方法内部输出：a出现10次
*/
public class Test1_kuozhan {
    public static void main(String[] args) throws IOException {
        count('a');
    }

    public static void count(char ch) throws IOException {
        //创建字节输入流
        FileInputStream fis = new FileInputStream("d:\\test.txt");
        //定义统计变量
        int count = 0;
        int len;
        //循环读取
        while ((len = fis.read()) != -1) {
            if (len == ch) {
                count++;
            }
        }
        System.out.println("文件中的字符"+ ch +"出现了"+count+"次");
        fis.close();
        /*try {
            int count = 0;
            int len;
            //循环读取
            while ((len = fis.read()) != -1) {
                if (len == ch) {
                    count++;
                }
            }
            System.out.println("文件中的字符" + ch + "出现了" + count + "次");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}

