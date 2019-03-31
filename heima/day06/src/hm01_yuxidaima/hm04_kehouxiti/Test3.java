package hm01_yuxidaima.hm04_kehouxiti;

import hm01_yuxidaima.MyRannable;

/*请编写程序，分别打印主线程的名称和子线程的名称。
		要求使用两种方式实现：
			第一种方式：继承Thread类。
			第二种方法：实现Runnable接口。
*/
public class Test3 {
    public static void main(String[] args) {
        MyThread my = new MyThread();
        my.start();
        String name= Thread.currentThread().getName();
        System.out.println("主线程1的名字:"+name);
        System.out.println("==============");
        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        t.start();
        String name1 =Thread.currentThread().getName();
        System.out.println("主线程2的名字:"+name1);
    }
}
