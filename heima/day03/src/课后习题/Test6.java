package 课后习题;

import java.util.HashSet;

/*练习六：HashSet存储自定义类型
六、定义人类，包含姓名和年龄属性。创建4个人存储到HashSet中，姓名和年龄相同的人看做同一人不存储。
*/
public class Test6 {
    public static void main(String[] args) {
        //创建一个HashSet集合
        HashSet<Person> list = new HashSet<>();
        //创建四个人并添加到集合
        list.add(new Person("张飞",28,"猪"));
        list.add(new Person("孙权",29,"鸡"));
        list.add(new Person("刘备",38,"猴"));
        list.add(new Person("关羽",30,"马"));
        list.add(new Person("孙权",29,"鸡"));

        System.out.println(list);
    }
}
