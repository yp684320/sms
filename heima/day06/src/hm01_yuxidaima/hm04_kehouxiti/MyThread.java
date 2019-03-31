package hm01_yuxidaima.hm04_kehouxiti;

public class MyThread extends Thread {
    @Override
    public void run() {
        String name = getName();
        System.out.println("子线程1的名字:"+name);
    }
}
