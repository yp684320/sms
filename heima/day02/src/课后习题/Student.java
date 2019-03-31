package 课后习题;

public class Student {
    //成员变量
    private String name;
    private int age;
    private String xb;
    //构造方法


    public Student() {
    }

    public Student(String name, int age, String xb) {
        this.name = name;
        this.age = age;
        this.xb = xb;
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

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    @Override
    public String toString() {
        return  name + '\'' + " " + age + " " + xb + '\'';
    }
}
