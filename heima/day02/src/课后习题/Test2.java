package 课后习题;

import java.util.ArrayList;
import java.util.Collection;

public class Test2 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:"+listTest(list, "a"));
        System.out.println("b:"+listTest(list, "b"));
        System.out.println("c:"+listTest(list, "c"));
        System.out.println("xxx:"+listTest(list, "xxx"));
    }
    public static int listTest(Collection<String> list,String s){
        //定义统计变量,并赋值为0
        int count= 0;
        //用增强for遍历集合
        for(String string : list){
            if (string.equals(s)) {
                count++;
            }
        }
        return count;
    }
}
