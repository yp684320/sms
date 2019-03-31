package day07;

import java.util.ArrayList;

//自定义4个学生对象,添加到集合并遍历
//创建学生对象
//创建ArrayList集合
//把学生对象作为元素添加到集合
//遍历集合
public class Demon08 {
    public static void main(String[] args) {
        /*String s1 = "李飞";
        String s2 = "李华";
        String s3 = "张开";
        String s4 = "冯奎";
        ArrayList<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        for(int i = 0;i < list.size();i++ ){
            System.out.print(list.get(i)+" ");
        }*/
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student("李飞",20);
        Student s2 = new Student("李华",34);
        Student s3 = new Student("张开",23);
        Student s4 = new Student("冯奎",37);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        for(int i = 0;i <list.size();i++ ){
            Student s = list.get(i);
            System.out.println(s.getName()+"----"+s.getAge());
        }
    }
}
