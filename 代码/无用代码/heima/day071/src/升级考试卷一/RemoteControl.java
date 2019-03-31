package 升级考试卷一;

import java.util.Scanner;

public class RemoteControl {
    public void controlTV(TV tv){
        System.out.println("遥控器控制电视");
        System.out.println("请输入节目名称:");
        //创建Scanner类
        Scanner sc = new Scanner(System.in);
          String s = sc.nextLine();
         tv. play(s);
        System.out.println("=========");
    }
}
