package day10.Test02;
/*4.定义会表演的行政部员工类(ActedAdminStaff)  继承 AdminStaff 实现 Actor接口
        a)实现抽象方法 play
        i.输出格式: 工号为001的行政部员工景甜在跳舞
        b)提供空参,带参构造方法*/
public class ActedAdminStaff extends AdminStaff implements Actor{
    //a)实现抽象方法 play

    @Override
    public void play() {
        System.out.println("工号为"+getId()+"的行政部员工"+getName()+"在跳舞");
    }
    //b)提供空参,带参构造方法

    public ActedAdminStaff() {
    }

    public ActedAdminStaff(String id, String name, int salary) {
        super(id, name, salary);
    }
}
