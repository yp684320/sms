package hm01_yuxidaima.hm04_kehouxiti;

public class MyThread6 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("子线程在执行");
        }
    }
}
