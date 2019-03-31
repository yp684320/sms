package day06;

public class TestTeacher {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setName("周老师");
        t.setAge(30);
        t.setContent("java面向对象");
        t.eat();
        t.jiangke();
        Student01 stu = new Student01("韩同学",18,"java面向对象");
        stu.eat();
        stu.study();

    }
}
