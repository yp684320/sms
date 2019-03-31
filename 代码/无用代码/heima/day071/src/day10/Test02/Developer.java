package day10.Test02;
/*5.定义开发部员工类(Developer)  继承 Employee
	a)实现抽象方法work()
		i.输出格式: 工号为010的开发部员工林俊杰在开发JavaEE应用
	b)提供空参,带参构造方法*/
public class Developer extends Employee{
    @Override
    public void work() {
        System.out.println("工号为"+getId()+"的开发部员工"+getName()+"在开发JavaEE应用");
    }

    public Developer() {
    }

    public Developer(String id, String name, int salary) {
        super(id, name, salary);
    }
}
