package hm01_yuxidaima.hm02_shoupiao;
//定义接口实现类
public class Ticket implements Runnable {
    private int ticket = 100;

    @Override
    //执行卖票操作
    public void run() {
        //每个窗口卖票的操作
        //窗口 永远 开启
        while (true) {
            synchronized ("") {//用同步代码块解决代码
                if (ticket > 0) {//有票可卖
                    try {//出票操作
                        //使用sleep模拟一下出票时间
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //获取当前线程的名字
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在售" + ticket--);
                }
            }
        }
    }
}