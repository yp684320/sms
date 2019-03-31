package hm01_yuxidaima;

public class Test1 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("李飞"+i);
                }
            }
        };
        new Thread(r).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("zhangfei"+i);
        }
    }
}
