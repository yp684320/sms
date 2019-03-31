package hm01_yuxidaima;

public class TestRunnable {
    public static void main(String[] args) {
        //创建自定义类对象  线程任务对象
        MyRannable mr = new MyRannable();
        //创建线程对象
        Thread t = new Thread(mr,"小猫");
        t.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("小旺"+i);
        }
    }
}
