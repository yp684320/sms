package hm01_yichang.hm02_duoxoiancheng;

public class MyThread extends Thread{

    public MyThread() {
    }
    /**
     * 重写run方法，完成该线程执行的逻辑
     */

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 ==0) {
                System.out.println("子线程打印输出偶数:"+ i);
            }
        }
        super.run();
    }
}
