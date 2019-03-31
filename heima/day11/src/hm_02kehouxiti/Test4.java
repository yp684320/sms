package hm_02kehouxiti;

import java.io.*;
import java.util.Scanner;

/*分析以下需求，并用代码实现
	实现一个验证码小程序，要求如下：
	1. 在项目根目录下新建一个文件：data.txt,键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占一行；
	2. 键盘录入一个需要被校验的验证码，如果输入的验证码在data.txt中存在：在控制台提示验证成功，如果不存在控制台提示验证失败
*/
public class Test4 {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲输出流对象
        BufferedWriter bos = new BufferedWriter(new FileWriter("date.txt"));
        //创建Scanner类对象
        Scanner sc = new Scanner(System.in);
        //提示输入信息
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入验证码:");
            String s = sc.next();
            bos.write(s);
            bos.newLine();
        }
        bos.close();
        //创建字节缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("date.txt"));
        System.out.println("请输入验证码:");
        String flag = null;
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            String s;
            while ((s = br.readLine()) != null) {
                if (s1.equals(s)) {
                    flag = "验证成功";
                    break;
                } else {
                    flag = "验证失败";
                }
            }
            System.out.println(flag);
        }

        br.close();


    }
}
