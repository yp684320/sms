package hm01_yichang.hm02_duoxoiancheng;
/*创建多线程对象，开启多线程。在子线程中输出1-100之间的偶数，主线程输出1-100之间的奇数。*/
public class Test {
    public static void main(String[] args) {
     MyThread mt = new MyThread();
      //开启线程
        mt.start();
        //在主方法中执行for循环
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println("主线程打印输出奇数:"+i);
            }
        }
    }
}
