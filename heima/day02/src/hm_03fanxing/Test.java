package hm_03fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
       /* Collection<String> c = new ArrayList<>();
        c.add("hhh");
        c.add("nn");
        c.add("bbbb");
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
        */
       //创建集合
        Collection<String> c = new ArrayList<>();
        //添加元素
        c.add("hhh");
        c.add("bbbb");
        c.add("aaaaaa");
        //获取迭代器
        Iterator<String> it = c.iterator();
        //遍历集合
        while (it.hasNext()){
            String next = it.next();
            System.out.println(next);

        }
}
}




