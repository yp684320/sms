package 预习代码;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetdemo {
    public static void main(String[] args) {
        //创建一个对象
        Set<String> set = new LinkedHashSet<>();
        set.add("1");
        set.add("aaa");
        set.add("ccccc");
        set.add("22");
        set.add("ccccbc");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
