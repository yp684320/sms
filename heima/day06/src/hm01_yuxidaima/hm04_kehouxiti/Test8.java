package hm01_yuxidaima.hm04_kehouxiti;
/*编写一个Java程序，要求在同一个类中除main线程外，再开启一个线程，2个线程都循环执行20次。*/
public class Test8 {
    public static void main(String[] args) {
        Runnable r =new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"执行第"+i+"次");
                }
            }
        };
        new Thread(r).start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"执行第"+i+"次");
        }
    }
}
