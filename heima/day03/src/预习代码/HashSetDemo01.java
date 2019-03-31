package 预习代码;

import java.util.HashSet;

public class HashSetDemo01 {
    public static void main(String[] args) {
        //创建集合对象 并添加元素
        HashSet<Student> stuset = new HashSet<>();
        //集合里添加元素
        Student s1 = new Student("小花",29);
        Student s2 = new Student("小海",20);
        Student s3 = new Student("小花",29);
        Student s4 = new Student("小白",19);
        stuset.add(s1);
        stuset.add(s2);
        stuset.add(s3);
        stuset.add(s4);
        //遍历集合并打印输出
        for (Student student : stuset) {
            System.out.println(student);
        }
    }
}
