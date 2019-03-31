package 课后习题;

import java.util.ArrayList;

public class Test {

        public static void main(String[] args) {
            //定义集合，向集合中添加student对象
            ArrayList<Student> list = new ArrayList<Student>();
            list.add(new Student("张三", 23, "男"));
            list.add(new Student("王五", 28, "男"));
            list.add(new Student("李四", 25, "男"));
            print(list);
            System.out.println("--------------");
            change(list);
            System.out.println("--------------");
            System.out.println(list);
        }
        //
        public static void change(ArrayList<Student> list) {
            //定义变量存放年龄
            int a = 0;
            //定义变量存放最大年龄的索引值
            int index = 0;
            //遍历集合获取年龄值，与a相比较
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getAge() > a) {
                    //如果年龄大于a，记录次数
                    index = i;
                    //并把年龄的最大值赋予a
                    a = list.get(i).getAge();
                }
            }
            System.out.println("年龄最大的学生是" + list.get(index).getName());
            //将年龄最大的学生姓名变为：小猪佩奇
            list.get(index).setName("小猪佩奇");
        }
        //定义方法，遍历集合输出
        public static void print(ArrayList<Student> list) {
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }


