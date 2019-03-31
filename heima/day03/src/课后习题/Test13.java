package 课后习题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/*十三、分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，如果成绩一样，那在成绩排序的基础上按照年龄由小到大排序。
姓名（String）	年龄（int）	分数（float）
liusan	20	90.0F
lisi	22	90.0F
wangwu	20	99.0F
sunliu	22	100.0F
*/
public class Test13 {
    public static void main(String[] args) {
        //1,创建三个学生对象
        Student s1 = new Student("liusan",20,90.0F);
        Student s2 = new Student("lisi",22,90.0F);
        Student s3 = new Student("wangwu",20,99.0F);
        Student s4 = new Student("sunliu",22,100.0F);
        //2,创建一个ArraysList集合
        ArrayList<Student> list = new ArrayList<>();
        //3,把学生添加到集合
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //成绩;一样的按年龄由小到大排列
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore() > o2.getScore()) {
                    return -1;
                } else if (o1.getScore() < o2.getScore()) {
                    return 1;
                } else {
                    if (o1.getAge() > o2.getAge()) {
                        return -1;
                    } else if (o1.getAge() < o2.getAge()) {
                        return 1;
                    } else {
                        return  0;
                    }

                }
            }
        });
        //遍历集合并输出
        for (Student student : list) {
            System.out.println(student);
        }
    }
}