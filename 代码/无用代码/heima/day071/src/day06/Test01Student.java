package day06;

public class Test01Student {
    public static void main(String[] args) {
        //创建一个学生类型
        Student s = new Student();
        System.out.println("s" + s);
        //直接输出成员变量
        System.out.println("姓名:" + s.name);
        System.out.println("年龄:" + s.age);
        System.out.println("------");
        //给成员变量赋值
        s.name = "李飞";
        s.age = 18;
        //再次输出成员变量
        System.out.println("姓名:" + s.name);
        System.out.println("年龄:" + s.age);
        System.out.println("------");
        //调用成员方法
        s.study();
        s.eat();
    }
}
