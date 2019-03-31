package 课后习题;

import java.util.ArrayList;

/*练习九：Collection集合练习
九、(复杂，并不难)定义一个学生类Student，包含三个属性姓名、年龄、性别，创建三个学生对象存入ArrayList集合中。
A：遍历集合遍历输出。
B：求出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。
*/
public class Test8 {
    public static void main(String[] args) {
        //创建Student对象
        Student s1 = new Student("小明", 20, "男");
        Student s2 = new Student("小红", 22, "女");
        Student s3 = new Student("小亮", 21, "男");
        //创建一个Student类集合
        ArrayList<Student> list = new ArrayList<>();
        //集合里添加元素/**/
        list.add(s1);
        list.add(s2);
        list.add(s3);
        //用增强for遍历集合
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println("===========");
        chang(list);
        System.out.println("===========");
        System.out.println(list);
    }

    //定义方法
    public static void chang(ArrayList<Student> list) {
        //定义一个统计变量  存放年龄
        int a = 0;
        //定义一个统计变量   存放最大年龄的索引
        int b = 0;
        //遍历集合获取最大年龄与a比较
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAge() > a) {
                //如果年龄大于a记录次数
                b = i;
                //并把年龄的最大值赋给a
                a = list.get(i).getAge();
            }
        }
        System.out.println("最大年龄的学生是: " + list.get(b).getName());
        //将最大年龄的学生姓名变为"小猪佩奇"
        list.get(b).setName("小猪佩奇");
    }
        //定义方法遍历集合并输出
        public static void print (ArrayList < Student > list) {
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }
