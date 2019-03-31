package hm_02kehouxiti;

import java.io.*;
import java.util.ArrayList;

/*定义一个学生类，成员变量有姓名，年龄，性别，提供setters和getters方法以及构造方法
定义一个测试类，在测试类创建多个学生对象保存到集合中，然后将集合存储到当前项目根目录下的stus.txt文件中。
*/
public class Test11 {
    public static void main(String[] args) throws IOException {
        //创建学生类集合
        ArrayList<Student> list= new ArrayList<>();
        list.add(new Student("张飞",20,"男"));
        list.add(new Student("张开",28,"男"));
        list.add(new Student("张华",27,"女"));
        list.add(new Student("张里",25,"男"));
        //创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stus.txt"));
        oos.writeObject(list);
        oos.close();
    }
}
