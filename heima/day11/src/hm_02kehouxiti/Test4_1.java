package hm_02kehouxiti;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*分析以下需求，并用代码实现
        实现一个验证码小程序，要求如下：
        1. 在项目根目录下新建一个文件：data.txt,键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占一行；
        2. 键盘录入一个需要被校验的验证码，如果输入的验证码在data.txt中存在：在控制台提示验证成功，如果不存在控制台提示验证失败
        */
public class Test4_1 {
    public static void main(String[] args) throws Exception {
        writeString2File();
        verifyCode();

    }
   /* public static void createCode1() throws IOException {
        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("date.txt"));
        //创建Scanner类对象
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <=3; i++) {
            System.out.println("请输入第"+i+"个验证码:");
            String s = sc.next();
            bw.write(s);
            bw.newLine();
        }
        //关闭资源
        bw.close();
    }*/
  /*  public static void code() throws IOException {
        //创建String集合  存放3个验证码
        ArrayList<String> list = new ArrayList<>();
        //创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("date.txt"));
        //读取数据化
        String len;
        while ((len = br.readLine())!= null) {
            list.add(len);
        }
        br.close();
        //创建Scanner类
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入验证码");
            String s = sc.next();
            if (list.contains(s)) {
                System.out.println("验证成功");
                break;
            } else {
                System.out.println("验证失败");
            }
        }
    }*/
  private static void verifyCode() throws Exception {
      //创建ArrayList集合，用于存储文件中的3个验证码
      ArrayList<String>list = new ArrayList<>();
      //创建高效字符缓冲输入流对象,并和data.txt文件关联
      BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
      String line = null;
      //循环读取每一行
      while(null!=(line = br.readLine())) {
          //将读到的每一行信息存入到list集合中
          list.add(line);
      }
      //关闭流对象
      br.close();
      //创建键盘录入对象
      Scanner sc = new Scanner(System.in);
      //提示用户输入验证码
      System.out.println("请输入一个验证码");
      String code = sc.nextLine();
      if(list.contains(code)) {
          System.out.println("验证成功");
      } else {
          System.out.println("验证失败");
      }
  }
    private static void writeString2File() throws Exception {
        //创建高效字符缓冲输出流对象并和data.txt文件关联
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("data.txt")));
        String line = null;
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<3;i++) {
            System.out.println("请输入第"+(i+1)+"个字符串验证码");
            //读取用户键盘录入的一行验证码信息
            line = sc.nextLine();
            //将读取到的一行验证码写入到文件中
            bw.write(line);
            //写入换行符
            bw.newLine();
        }
        //关闭流对象
        bw.close();
    }
}



