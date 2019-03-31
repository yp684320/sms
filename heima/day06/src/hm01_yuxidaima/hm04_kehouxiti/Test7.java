package hm01_yuxidaima.hm04_kehouxiti;
/*编写程序，创建两个线程对象，一根线程循环输出“播放背景音乐”，
另一根线程循环输出“显示画面”，要求线程实现Runnable接口，且使用匿名内部类实现*/
public class Test7 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("播放音乐");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("显示画面");
                }
            }
        }).start();
    }
}
