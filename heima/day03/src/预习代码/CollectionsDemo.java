package 预习代码;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        //排序方法
        //默认排序
        Collections.sort(list);
        System.out.println(list);
        //打乱排序
        Collections.shuffle(list);
        System.out.println(list);
    }
}
