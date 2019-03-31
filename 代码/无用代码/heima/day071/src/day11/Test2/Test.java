package day11.Test2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //创建老师对象
        Teacher t = new Teacher("张老师");
        //创建学生对象
        Student s1 = new Student("小明");
        Student s2 = new Student("小亮");
        Student s3 = new Student("小红");
        //创建学生集合并添加学
     ArrayList<Student> list = new ArrayList<>();
     list.add(s1);
     list.add(s2);
     list.add(s3);
     //创建课程对象
        Course c = new Course("Java",t,list);
        t.dianMing(list);
        c.show();
        //t.getName();


    }
}
