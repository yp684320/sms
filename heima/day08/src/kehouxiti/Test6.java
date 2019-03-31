package kehouxiti;

import java.util.ArrayList;
import java.util.stream.Stream;

/*	练习八：Stream综合练习
问题：
现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用Stream方式进行以
下若干操作步骤：
1. 第一个队伍只要名字为3个字的成员姓名；
2. 第一个队伍筛选之后只要前6个人；
3. 第二个队伍只要姓张的成员姓名；
4. 第二个队伍筛选之后不要前1个人；
5. 将两个队伍合并为一个队伍；
6. 根据姓名创建Student对象；
7. 打印整个队伍的Student对象信息。
*/
public class Test6 {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老字子");
        one.add("庄你子");
        one.add("孙用子");
        one.add("洪七公");
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");
        //获取集合的流
       //1. 第一个队伍只要名字为3个字的成员姓名；
       //2. 第一个队伍筛选之后只要前6个人；
        Stream<String> stream = one.stream().filter(s -> s.length() == 3).limit(6);
        // 3. 第二个队伍只要姓张的成员姓名；
        //4. 第二个队伍筛选之后不要前1个人；
        Stream<String> stream1 = two.stream().filter(s -> s.startsWith("张")).skip(1);
        //5. 将两个队伍合并为一个队伍；
       Stream.concat(stream, stream1).map(Student::new).forEach(System.out::println);



    }
}
