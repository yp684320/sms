package hm01_yuxidaima;

import java.io.IOException;
import java.nio.CharBuffer;

public class MyRannable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

}
