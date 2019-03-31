package day07;


/*使用学生数组,存储三个学生对象

*/
public class TestStudent {
    public static void main(String[] args) {
       // 1,创建学生数组
      Student[] students = new Student[3];
       // 2,创建学生对象
      Student s1 = new Student("曹操",48);
      Student s2 = new Student("刘备",35);
      Student s3= new Student("孙权",30);
       // 3,把学生对象作为元素赋值给学生数组
      students[0] = s1;
      students[1] = s2;
      students[2] = s3;
      //4.遍历学生数组
        for(int i = 0;i < students.length;i++){
            //Student s = new Student("曹操",48);
            Student s = students[i];
            System.out.println(s.getName()+"----"+s.getAge());
        }
    }
}
