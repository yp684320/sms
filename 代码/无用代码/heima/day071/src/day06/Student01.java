package day06;

public class Student01 {
    //成员变量
    private String name;
    private int age;
    private String content;
    //成员方法
    public void eat(){
        System.out.println("年龄为"+age+"姓名为"+name+"正在吃饭...");
    }
    public void study(){
        System.out.println("年龄为"+age+"姓名为"+name+"正在专心致志的听着"+content+"的知识...");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //构造方法

    public Student01() {
    }

    public Student01(String name, int age, String content) {
        this.name = name;
        this.age = age;
        this.content = content;
    }
}
