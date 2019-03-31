package hm_03fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo01Generic {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("sdfhuk");
        coll.add("哈哈哈");
        coll.add("123");
        //获取迭代对象
        Iterator<String> it = coll.iterator();
        while(it.hasNext()){
            //当使用Iterator<String>控制元素后,获取到的元素就直接是String类型
            String str =  it.next();
            System.out.println(str.length());
        }
    }
}
