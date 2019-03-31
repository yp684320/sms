package hm01_yuxidaima;

public class Demo {
    public static void main(String[] args) {
        //创建线程任务对象
        Ticket ticket = new Ticket();
        //创建三个窗口对象
        Thread t1 = new Thread(ticket,"窗口1");
        Thread t2 = new Thread(ticket,"窗口2");
        Thread t3 = new Thread(ticket,"窗口3");
        //同时卖票
        t1.start();
        t2.start();
        t3.start();
    }


}
 class Ticket1 implements Runnable{
    private int ticket = 100;

     @Override
     public void run() {
         while (true) {
        sellTlcked();
         }
     }
     public synchronized void sellTlcked(){
                 if (ticket > 0) {
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     String name = Thread.currentThread().getName();
                     System.out.println(name + "正在卖" + ticket--);
                 }


         }
}

