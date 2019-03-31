package hm01_yuxidaima.hm03_baozipumaibaozi;

import java.util.ArrayList;

public class Add implements Runnable {
    private ArrayList<String> list;

    public Add(ArrayList<String> list) {
        this.list = list;
    }

    //生产包子
    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                synchronized (list) {//list作为锁集合是唯一的
                    if (list.size() >0) {
                        //存元素的线程进入等待状态
                            list.wait();
                    }
                       //集合中已经有元素了  唤醒取元素的线程
                    Thread.sleep(1);
                    String baozi = "包子"+i++;
                    list.add(baozi);
                    System.out.println("生产包子:"+baozi);
                    list.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}