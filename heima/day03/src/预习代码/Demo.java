package 预习代码;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        //创建四个学生对象并添加到集合
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("jki",18));
        list.add(new Student("jkm",19));
        list.add(new Student("jkl",23));
        list.add(new Student("jkd",13));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();//以学生的年龄升序shuchu
            }
        });

        for (Student s : list) {
            System.out.println(s);
        }
    }
}
