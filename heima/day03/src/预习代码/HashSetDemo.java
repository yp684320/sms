package 预习代码;
//set集合中的元素不能重复
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        //创建Set集合
        HashSet<String> set = new HashSet<>();
        //添加元素
        set.add("abc");
        set.add("bnj");
        set.add("abc");
        set.add("hjk");
        set.add("hk");
        set.add("hjpk");
        set.add("hjmmmk");
        //遍历集合\
        for (String s : set) {
            System.out.println(s);
        }
    }
}
