package day08;

import java.util.ArrayList;
import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<User> list =new ArrayList<>();
        //创建用户对象
        User a1 = new User("Jack","1234");
        User a2 = new User("rose","5678");
        User a3 = new User("tom","0000");
        //创建Scanner类,并接受数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String a = sc.nextLine();
        System.out.println("请输入密码");
        String b = sc.nextLine();

    }

 /*   public static String get(String name,String number){
        if (a.equals(b)) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录结果:密码错误");
        }

    }*/
}
