package hm01_yuxidaima.hm03_baozipumaibaozi;

import java.util.ArrayList;

public class TestBaoZi {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //创建线程对象
        Add a = new Add(list);
        Thread t1 = new Thread(a);
        t1.start();

        Remove r = new Remove(list);
        Thread t2 = new Thread(r);
        t2.start();
    }
}
