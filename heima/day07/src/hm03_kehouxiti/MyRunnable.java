package hm03_kehouxiti;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("我需要一位老师");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("老师来了"+Thread.currentThread().getName());
        System.out.println("教我java,交完后,老师回到了教师");

    }
}
