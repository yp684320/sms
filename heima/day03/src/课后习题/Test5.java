package 课后习题;

import java.util.LinkedList;

/*五、根据要求练习LinkedList方法：
（1）基本方法：add, set, get, remove, clear, size等方法；
（2）特有方法：addFirst, addLast, getFirst, getLast, removeFirst,removeLast, push, pop, clear等方法。
*/
public class Test5 {
    public static void main(String[] args) {
        //创建一个LinkedList集合
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("呵呵");//集合里添加元素
        list.add("aa");
        list.add("22");
        list.add("ccccc");
        list.add("bbb");
        System.out.println(list);
        list.add(4,"阿豪");//将指定索引处index添加指定的元素" "
        System.out.println(list);
      /*  System.out.println("=======");
        list.set(2,"哈哈");//将指定索引处添加指定的元素
        list.set(4,"谢谢");
        list.set(3,"哈哈");
        System.out.println(list);
        System.out.println("======");
        String s = list.get(0);//获取指定索引处的元素
        System.out.println(s);
        String s1 = list.get(3);
        System.out.println(s1);
        String s2 = list.get(4);
        System.out.println(s2);
        System.out.println("==========");
        String a = list.remove(2);//删除指定索引处的元素
        System.out.println(a);
        System.out.println(list);
        System.out.println("======");
        System.out.println(list.size());;//输出集合的长度
        list.addFirst("好");
        list.addLast("的");
        System.out.println(list);
        list.clear();//清空集合里的元素
        System.out.println(list);*/
        /*String b = list.getFirst();
        System.out.println(b);
        String c =  list.getLast();
        System.out.println(c);
        System.out.println("====");*/
       String a =  list.pop();
        System.out.println(a);
        System.out.println("=====");
        list.push("bbb");//将指定元素复制到第一个元素的位置
        System.out.println(list);


    }
}
