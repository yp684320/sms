package hm_03kehouxiti;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/*练习三:字符输出流写出字符数据并存到集合中
需求说明：从控制台接收3名学员的信息，每条信息存储到一个Student对象中，将多个Student对象存储到一个集合中。
输入完毕后，将所有学员信息存储到文件Student.txt中。每名学员信息存储一行，多个属性值中间用逗号隔开。
*/
public class Test3_kuozhan {
    public static void main(String[] args) throws IOException {
        //创建学生类jihe
        ArrayList<Student> list = new ArrayList<>();
        //创建Scanner类对象
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            //提示输入
            System.out.print("请输入第"+i+"个学生姓名:");
            //接受数据
            String name = sc.next();
            System.out.print("请输入第"+i+"个学生年龄:");
            Integer age = sc.nextInt();
            //把信息封装到学生类中
            Student s = new Student( name,age);
            //把学生信息添加到集合中
            list.add(s);
        }
        System.out.println(list);
        //创建字符输出流对象
        FileWriter fw = new FileWriter("Student.txt");
        //遍历集合
        for(int i= 0;i < list.size();i ++){
            Student s = list.get(i);
            String len = s.getName()+","+s.getAge();
            fw.write(len);
            fw.write("\r\n");
        }

        fw.close();

    }
}
