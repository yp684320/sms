package hm01_yuxidaima.hm04_kehouxiti;

public class SuiDao implements Runnable {
   private int count = 0;
    @Override
    public void run() {
     cross();
    }

    public synchronized void cross(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
        System.out.println(Thread.currentThread().getName()+"已经通过隧道,他是第"+count+"通过的");
    }
}
