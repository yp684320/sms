package day10.Test02;
/*9.老板类Boss类
	a)属性: 年龄,姓名
	b)行为:
		i.安排工作(letWork(Employee e)
			1.调用e对象的工作方法
		ii.组织表演(letPlay(Actor a)
			1.调用a对象的,表演方法.
	c) 提供空参,带参构造方法;setters和getters方法*/
public class Boss {
    private String name;
    private int age;
    public void letWork(Employee e){
      e.work();
    }
    public void letPlay(Actor a){
       a.play();
    }

    public Boss() {
    }

    public Boss(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
