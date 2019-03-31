package hm01_yuxidaima.hm02_shoupiao;

public class TestTicket {
    public static void main(String[] args) {
        //创建任务对象
        Ticket t = new Ticket();
        //创建三个窗口线程对象
        Thread thread1 =new Thread(t,"窗口1");
        Thread thread2 =new Thread(t,"窗口2");
        Thread thread3 =new Thread(t,"窗口3");
        //开启线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
