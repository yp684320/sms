package day06;

public class Manager {
    //成员变量
    private String name;
    private String number;
    private int[] salary;
    //构造方法

    public Manager() {
    }
    public Manager(String name, String number, int[] salary) {
        this.name = name;
        this.number = number;
        this.salary = salary;
    }

    //成员方法
    public void intro(){
        System.out.println("经理姓名:"+name);
        System.out.println("工号:"+number);
    }
    public void showSalary(){
        System.out.println("基本工资:"+salary[0]+";奖金为:"+salary[1]);
    }
    public void work(){
        System.out.println("正在怒路的做着管理工作,分配任务,检查员工提交上来的代码....");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSalary(int[] salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int[] getSalary() {
        return salary;
    }
}


