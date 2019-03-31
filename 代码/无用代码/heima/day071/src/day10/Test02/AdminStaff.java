package day10.Test02;
//3.定义行政部员工类(AdminStaff)  继承 Employee
//	a)实现抽象方法work()
//		i.输出格式: 工号为001的行政部员工景甜在采购物品
//	b)提供空参,带参构造方法
public class AdminStaff extends Employee  {
    //	a)实现抽象方法work()
    @Override
    public void work() {
        System.out.println("工号为"+getId()+"的行政部员工"+getName()+"在采购物品");
    }
    //	b)提供空参,带参构造方法

    public AdminStaff() {
    }

    public AdminStaff(String id, String name, int salary) {
        super(id, name, salary);
    }
}
