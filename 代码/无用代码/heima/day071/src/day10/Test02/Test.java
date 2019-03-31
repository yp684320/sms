package day10.Test02;
/*10.测试类Test
	a)提供main方法
	b)在main方法中
		i.创建会表演的行政部员工类(ActedAdminStaff)对象 aas,工号赋值为001,姓名赋值为景甜,工资赋值5000
		ii.创建会表演的开发部员工类(ActedDeveloper) 对象ad,工号赋值为010,姓名赋值为林俊杰,工资赋值为10000
		iii.创建会表演的财务部员工类(ActedTreasurer) 对象 at,工号赋值为100,姓名赋值为林思意,工资赋值为8000
		iv.创建老板(Boss)对象,姓名赋值为薛之谦,年龄赋值为30
		1.调用三次letWork(Employee e)方法,分别传入ass,ad,at
		2.调用三次letPlayo(Actor a)方法,分别传入ass,ad,at

*/
public class Test {
    public static void main(String[] args) {
//i.创建会表演的行政部员工类(ActedAdminStaff)对象 aas,工号赋值为001,姓名赋值为景甜,工资赋值5000
        ActedAdminStaff ass = new ActedAdminStaff("001","景甜",5000);
      //ii.创建会表演的开发部员工类(ActedDeveloper) 对象ad,工号赋值为010,姓名赋值为林俊杰,工资赋值为10000
        ActedDeveloper ad = new ActedDeveloper("010","林俊杰",10000);
        //iii.创建会表演的财务部员工类(ActedTreasurer) 对象 at,工号赋值为100,姓名赋值为林思意,工资赋值为8000
        ActedTreasurer at = new ActedTreasurer("100","林思意",8000);
        //iv.创建老板(Boss)对象,姓名赋值为薛之谦,年龄赋值为30
        //		1.调用三次letWork(Employee e)方法,分别传入ass,ad,at
        //		2.调用三次letPlayo(Actor a)方法,分别传入ass,ad,at
        Boss boss = new Boss("薛之谦",30);
        boss.letWork(ass);
        boss.letWork(ad);
        boss.letWork(at);
        boss.letPlay(ass);
        boss.letPlay(ad);
        boss.letPlay(at);
    }
}
