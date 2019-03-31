package 课后习题;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*[注意]1,HashSet是Set接口的一个实现类,里面存放的元素不可重复,但是是无序
        2,LinkedHashSet是HashSet一个子类,它存放元素有序
练习八：LinkedHashSet基本使用
八、使用LinkedHashSet存储以下元素："王昭君","王昭君","西施","杨玉环","貂蝉"。使用迭代器和增强for循环遍历LinkedHashSet。
*/
public class Test8 {
    public static void main(String[] args) {
        //创建一个LinkedHashSet集合,它是HashSet的zilei,是Set的子类
        Set<String> set = new LinkedHashSet<>();
        //集合里添加元素
        set.add("王昭君");
        set.add("貂蝉");
        set.add("西施");
        set.add("杨玉环");
        set.add("王昭君");
        //用迭代器遍历集合
        Iterator<String> it = set.iterator();//获取相应的迭代器
        //遍历集合
        while (it.hasNext()) {
            String s = it.next();
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("=====");
        //用增强for遍历集合
        for (String a : set) {
            System.out.print(a+" ");
        }



    }
}
