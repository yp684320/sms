package hm_02kehouxiti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*描述:将上一题保存到stu.txt文件中的学生对象读取出来。*/
public class Test8 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //反序列化
        //创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stu.txt"));
        //读取一个对象
        Student s =(Student) ois.readObject();
        System.out.println(s);
        ois.close();
    }
}
