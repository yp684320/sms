package hm01_yuxidaima;

public class Demo01 {
    public static void main(String[] args) {
        //创建线程任务对象
        Ticket1 ticket = new Ticket1();
        //创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");
        //同时卖票
        t1.start();
        t2.start();
        t3.start();
    }
}
    class Ticket implements Runnable {
        private int ticket = 100;
       // Object lock = new Object();

        @Override
        public void run() {
            while (true) {
                synchronized (new Object()) {
                    if (ticket > 0) {
                        /*try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        String name = Thread.currentThread().getName();
                        System.out.println(name + "正在卖" + ticket--);
                    }

                }
            }
        }
    }
