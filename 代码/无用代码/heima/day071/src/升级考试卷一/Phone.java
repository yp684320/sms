package 升级考试卷一;

public class Phone implements RedRay {
    @Override
    public void controlTV(TV tv) {
        System.out.println("手机开启红外功能,控制电视");
        System.out.println("请输入节目名称:");
       java.util.Scanner sc = new java.util.Scanner(System.in);
        String s1 = sc.nextLine();
        tv.play(s1);
}
}
