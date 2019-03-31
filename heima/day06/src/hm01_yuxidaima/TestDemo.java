package hm01_yuxidaima;

public class TestDemo {
    public static void main(String[] args) {
        //创建子类对象
        MyRunnable1 myRunnable = new MyRunnable1();
        //创建Thread对象
        Thread thread = new Thread(myRunnable);
        //开启线程
        thread.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("kkk"+i);
        }


    }
}
 class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("zixiamcheng"+i);
        }

    }
}
