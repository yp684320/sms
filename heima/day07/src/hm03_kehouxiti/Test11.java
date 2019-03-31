package hm03_kehouxiti;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*问题：对Java基础班学生的考试成绩进行排序
1.	定义一个学生类，有两个属性。姓名，考试成绩
2.	在测试类中定义一个学生数组，存储学生信息。
3.	使用Lambda省略格式写法对学生数组按照考试成绩由高到低进行排序。
*/
public class Test11 {
    public static void main(String[] args) {
        Student[] arr = {new Student("李飞",98),new Student("李华",90),new Student("王凯",85)};
       /* Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore()-o2.getScore();
            }
            
        });*/
        Arrays.sort(arr,((o1, o2) -> (o1.getScore()-o2.getScore())));
        for (Student student : arr) {
            System.out.println(student);

        }
    }

}
