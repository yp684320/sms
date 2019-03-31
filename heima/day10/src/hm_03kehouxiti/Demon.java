package hm_03kehouxiti;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demon {
    public static void main(String[] args) throws IOException {
        // 1.定义学生类, 定义存学生的集合
        ArrayList<Student> list = new ArrayList<Student>();
        // 2.通过3次循环，完成如下操作
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i<= 3; i++) {
            // 键盘输入学生的信息，
            System.out.print("请输入第" + i + "名学生的姓名：");
            String name = sc.next();
            System.out.print("请输入第" + i + "名学生的年龄：");
            Integer age = sc.nextInt();
            // 把信息封装到Student对象中
            Student s = new Student(name,age);
            // 把Student对象存到集合里
            list.add(s);
        }
        // 3.将所有学员信息存储到文件Student.txt中。
        FileWriter out = new FileWriter("Student.txt");
        // 每名学员信息存储一行，多个属性值中间用逗号隔开。
        for (int i = 0; i<list.size(); i++) {
            // 1.获取集合中每一个学生对象
            Student s = list.get(i);
            // 2.获取对象中的每一个属性值,多个属性值中间用逗号隔开
            String line =  s.getName() + "," + s.getAge();
            // 3.按照指定的格式把对象的属性值，写入到文件中
            out.write(line);
            out.write(System.lineSeparator());
        }
        out.close();// 关闭流

    }
}
