package hm_bainli;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
       File file = new File("D:\\itcast\\heima\\day07\\src\\hm01_lambda");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().endsWith(".java"))
                {
                    System.out.println(file1);
                }
        }

    }
}
