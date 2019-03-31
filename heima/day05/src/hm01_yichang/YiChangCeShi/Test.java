package hm01_yichang.YiChangCeShi;
/*请使用代码实现
每一个学生(Student)都有学号,姓名和分数,分数永远不能为负数
如果老师给学生赋值一个负数,抛出一个自定异常
*/
public class Test {
    public static void main(String[] args) {
        //使用满参构造创建一个对象,分数传入一个负数,运行程序
       // Student student = new Student("小飞",-30);注掉的原因是一旦遇到异常后面的代码将不再执行
      Student s = new Student();
      s.setName("xiaofei");
      s.setScore(98);
      s.setScore(-20);
    }
}
