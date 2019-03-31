package hm01_yuxidaima.hm03_baozipumaibaozi;

import java.util.ArrayList;

public class Remove implements Runnable{
    private ArrayList<String> list;

    public Remove(ArrayList<String> list) {
        this.list = list;
    }
    //卖包子
    @Override
    public void run() {
        try {
            int i = 0;
            //卖包子  开启窗口
            while (true) {
                synchronized (list){
                    if (list.size()== 0) {//如果集合中没有元素  获取元素的集合处于等待

                            list.wait();
                       }
                        //如果集合中有元素则获取元素的线程获取元素(删除)
                    Thread.sleep(2);
                    String remove = list.remove(0);
                    //打印集合  集合中没有元素了
                    System.out.println("卖出包子:"+remove);
                    //集合中已经没有元素  唤醒添加元素的线程  集合里添加元素
                    list.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
