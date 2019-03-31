package day10.Test02;
/*7.定义财务部员工类(Treasurer)  继承 Employee
	a)实现抽象方法work()
		i.输出格式: 工号为100 的财务部员工林思意在对账
	b)提供空参,带参构造方法*/
public class Treasurer extends Employee{
    @Override
    public void work() {
        System.out.println("工号为"+getId()+"的财务部员工"+getName()+"在对账");
    }

    public Treasurer() {
    }

    public Treasurer(String id, String name, int salary) {
        super(id, name, salary);
    }
}
