package hm_06ceshifuxi;
//StringBuilder的俩个方法的应用
  //StringBuilder里添加元素:
// `1,public StringBuilder append(...) ：添加任意类型数据的字符串形式，并返回当前对象自身。
// 2,public String toString() ：将当前StringBuilder对象转换为String对象。
public class Demo {
    public static void main(String[] args) {
        //创建一个StringBuilder类
       /* StringBuilder sb = new StringBuilder();
        //往StringBuilder里添加元素  可以添加任何类型
        sb.append("啊啊啊  ");
        sb.append(true +" ");
        sb.append(100);
        sb.append('a');
        System.out.println(sb);
        //把StringBuilder转换为String
        String s = sb.toString();
        System.out.println(s);//当我们在调用一个方法时,返回一个对象,再用这个对象调用方法时,可以把代码写在一起
        String s1 = sb.append("啊啊啊  ").append(true +" ").append(100).append('a').toString();
        System.out.println(s1);*/
        StringBuilder builder = new StringBuilder();
     //   可以添加 任何类型     
        builder.append("hello");
        builder.append(true);
        builder.append(100);
         //将StringBuilder转换为String类型         
        String s = builder.toString();
         System.out.println(s) ;
        //在我们开发中，会遇到调用一个方法后，返回一个对象的情况。然后使用返回的对象继续调用方法。                  
        //这种时候，我们就可以把代码现在一起，如append方法一样，代码如下 //链式编程         
        String s2 = builder.append("hello").append(true).append(100).toString();
        System.out.println(s2);






    }

}
