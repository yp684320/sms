package hm_02kehouxiti;

import java.io.*;

/*描述:定义一个学生类，包含姓名，年龄，性别等成员变量，提供setters和getters方法以及构造方法。
在测试类中创建一个学生对象，给学生对象的三个成员变量赋值。
然后将该对象保存到当前项目根目录下的stu.txt文件中。*/
public class Test7 {
    public static void main(String[] args) throws IOException {
        //创建学生类对象
        Student s = new Student("张飞", 20, "男");
        //创建序列化输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stu.txt"));
        oos.writeObject(s);
        oos.close();


    }
}
