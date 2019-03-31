package day06;

public class Test02Student {
    public static void main(String[] args) {
        //创建一个学生类,无构造参数
        Student02 s = new Student02();
        s.setName("李飞");
        s.setAge(30);
        System.out.println(s.getName()+"----"+s.getAge());
        //带参数构造
        Student02 s2=new Student02("阿伟",39);
        System.out.println(s2.getName()+"----"+s2.getAge());
    }
}
