package 课后习题;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String sx;

    public Person() {
    }

    public Person(String name, int age, String sx) {
        this.name = name;
        this.age = age;
        this.sx = sx;
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

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(sx, person.sx);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, sx);
    }

    @Override
    public String toString() {
        return name + '\t' + age +"  "+ sx + '\t'
                ;
    }
}
