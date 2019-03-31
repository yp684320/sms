package day09.Test4;

public class Test4 {
    public static void main(String[] args) {
        //创建Teacher类
        Teacher t = new Teacher("王小平",30,"Java");
          t.teach();
          //创建Student类
        Student s = new Student("李小乐",20,"90");
           s.exam();
    }

}
//定义Person类
class Person{
    //成员变量
   private String name ;
    private int age;
    //构造方法
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
//定义Teacher类
class Teacher extends Person {
    //成员变量
   private String course;
    //构造方法

    public Teacher() {
    }

    public Teacher(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    public Teacher(String course) {
        this.course = course;
    }
    //成员方法
    public void teach(){
        System.out.println("年龄"+getAge()+"岁的"+getName()+"老师,讲授"+course+"课");

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
//定义Student类
class Student extends Person{
    //成员变量
   private String score;
    //构造方法

    public Student() {
    }

    public Student(String score) {
        this.score = score;
    }
    //成员方法

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Student(String name, int age, String score) {
        super(name, age);
        this.score = score;
    }

    public void exam(){
        System.out.println(getName()+"同学,考试得了:"+score);
    }
}
