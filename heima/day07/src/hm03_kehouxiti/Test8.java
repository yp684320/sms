package hm03_kehouxiti;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*使用线程池创建多线程。模拟同学找老师学习Java。
1.	创建线程池对象，包含2个线程。从线程池中获取线程对象，然后调用MyRunnable中的run()。
2.	在MyRunnable实现类中，首先在控制台打印需求，“我需要一个老师”。
模拟需要2秒钟时间老师可以过来指导学生，并在控制台打印老师的姓名。
最后，在控制台打印“教我java,教完后，老师回到了办公室”；
*/
public class Test8 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        MyRunnable mr = new MyRunnable();
        service.submit(mr);
        service.submit(mr);
    }
}
