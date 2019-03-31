package day10.Test02;
/*1.定义抽象员工类(Employee)
	a)属性:工号(id),姓名(name)和工资(salary)
	b)抽象方法 (work)
	c)提供空参,带参构造方法和setters,getters方法*/
public abstract class Employee {
    //a)属性:工号(id),姓名(name)和工资(salary)
    private String id;
    private String name;
    private int salary;
   // b)抽象方法 (work)
    public abstract void work();
    //c)提供空参,带参构造方法和setters,getters方法
    public Employee() {
    }

    public Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
