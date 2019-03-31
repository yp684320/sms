package day08;

public class Demon01 {
    public static void main(String[] args) {
       /* //空字符串
        String s ="";
        //通过字符数组构造字符串
        char[] ch = {'a','b','c'};
        String st =new String(ch);
        //通过字节数组构造字符串
        byte[] b= {97,98,99};
        String st1 = new String(b);*/
       //字符串之间的比较
       //创建字符串对象
       String s1 = "Hello";
       String s2 = "hello";
       String s3 = "Hello";
       //boolean equals(Object obj)比较字符串的内容是否相同,区分大小写
        System.out.println(s1.equals(s2));//false
        System.out.println(s1.equals(s3));//true
        System.out.println(s2.equals(s3));//false
        //比较字符串的内容是否相同,忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s2.equalsIgnoreCase(s3));

    }
}
