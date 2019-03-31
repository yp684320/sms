package hm03_kehouxiti;

public class Test {
    int start = 1;
    int end = 99;

    public static void main(String[] args) {
        new Test().method();
    }
    public void method(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = start; i < end; i++) {
                    System.out.println(i);
                }
            }
        });
    }
}
