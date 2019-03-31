package hm01_yuxidaima;

public class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("zixiamcheng"+i);
        }

    }
}
