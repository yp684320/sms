package day06;

public class Coder {
    //成员变量
    private String name;
    private String number;
    private int salary;
    //成员方法
    public void intro(){
        System.out.println("姓名:"+name);
        System.out.println("工号:"+number);
    }
    public void showSalary(){
        System.out.println("基本工资为"+salary+",奖金无");
    }
    public void work(){
        System.out.println("正在努力写代码....");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getSalary() {
        return salary;
    }
    //构造方法

    public Coder() {
    }

    public Coder(String name, String number, int salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;
    }
}
