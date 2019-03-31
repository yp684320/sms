package hm01_lambda;

public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程");
            }
        });
        new Thread(
            ()-> {
                System.out.println("多线程");
            }
        );
    }
}
