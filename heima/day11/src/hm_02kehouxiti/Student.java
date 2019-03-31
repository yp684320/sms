package hm_02kehouxiti;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    private int age;
    private String xb;

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", xb='" + xb + '\'' +
                '}';
    }
}
