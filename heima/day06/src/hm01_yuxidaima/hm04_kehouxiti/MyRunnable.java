package hm01_yuxidaima.hm04_kehouxiti;

public class MyRunnable implements Runnable {
    @Override
    public void run() {

        String name2 =Thread.currentThread().getName();
       System.out.println("子线程2的名字是:"+name2);
    }
}
