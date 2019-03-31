package hm01_yuxidaima;
/*多线程
1,定义一个Thread子类继承Thread类
2,重写run()方法
3,调用start()方法
*/
public class Test {
    public static void main(String[] args) {
        //创建MyThread对象
       MyThread mt = new MyThread("李飞");
       mt.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("张华"+i);
        }
    }
}
