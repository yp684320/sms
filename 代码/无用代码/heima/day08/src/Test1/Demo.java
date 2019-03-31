package Test1;

import java.util.Scanner;

class Test1 {

    public static void main(String[] args) {

        String str = "23.23458789";
        System.out.println("原数字字符串:" + str);

        HandleAble s1 = new HandleAble() {
            @Override
            public String handleString(String str) {
                return str.substring(0, str.indexOf("."));
            }
        };
        String string = s1.handleString(str);

        System.out.println("取整后:" + string);

        int num = new Scanner(System.in).nextInt(); // 假设录入4

        HandleAble s2 = new HandleAble() {
            @Override
            public String handleString(String str) {

                int i = str.indexOf(".") + num + 1;
                char c = str.charAt(i);
               // System.out.println(c);

                if (c <= '4') {
                    return str.substring(0, i).toString();
                } else {
                    char c1 = (char) (str.charAt(str.indexOf(".") + num)+1 );
                    return str.substring(0, i - 1) +c1;

                }
            }
        };
        String sss = s2.handleString(str);
        System.out.println("保留" + num + "位小数后:" + sss);

    }
}

interface HandleAble {
    public abstract String handleString(String str);
}
