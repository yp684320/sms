package hm01_yuxidaima.hm04_kehouxiti;
/*编写程序，在主线程中，循环输出“主线程执行”；在一条新线程中，循环输出“子线
程执行”
*/
public class Test6 {
    public static void main(String[] args) {
        MyThread6 myThread6 = new MyThread6();
        myThread6.start();
        while (true) {

        System.out.println("主线程执行======");
        }
    }
}
