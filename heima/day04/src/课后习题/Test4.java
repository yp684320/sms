package 课后习题;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*六、现在有一个map集合如下：
Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
要求：
1.遍历集合，并将序号与对应人名打印。
2.向该map集合中插入一个编码为5姓名为李晓红的信息
	3.移除该map中的编号为1的信息
	4.将map集合中编号为2的姓名信息修改为"周林
*/
public class Test4 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
        //使用keySet()遍历集合
        Set<Integer> set =  map.keySet();
        for (Integer integer : set) {
            System.out.println(integer+" "+map.get(integer));
        }
        //使用迭代器遍历
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer a = iterator.next();
            System.out.println(a +"  "+map.get(a));

        }
        //向集合里添加元素
        map.put(5,"李晓红");
        System.out.println(map);
        //移除指定键的值
        map.remove(1);
        System.out.println(map);
        //修改指定键的值
        map.put(2,"周林");
        System.out.println(map);


    }
}
