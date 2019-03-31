package day11.Test2;

import java.util.ArrayList;

/*定义课程类：

- 属性：课程名称，讲师，学生集合。
- 提供基本的构造方法和get方法，set方法
- 成员方法：show方法，打印课程信息，老师姓名，学生是否上课情况。
*/
public class Course {
    private String name ;
    private Teacher t;
    private ArrayList<Student> slist;

    public Course() {
    }

    public Course(String name, Teacher t, ArrayList<Student> slist) {
        this.name = name;
        this.t = t;
        this.slist = slist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getT() {
        return t;
    }

    public void setT(Teacher t) {
        this.t = t;
    }

    public ArrayList<Student> getSlist() {
        return slist;
    }

    public void setSlist() {
        this.slist = slist;
    }
    public void show (){
        System.out.println("课程信息: "+name
        );
        System.out.println("老师姓名: "+t.getName());
       for (int i = 0; i <slist.size() ; i++) {
            Student student = slist.get(i);
            String name = student.getName();
            if (student.isCome()){
                System.out.println(name+"来上课");
            }else{
                System.out.println(name+"没来上课");
            }
        }

    }
}
