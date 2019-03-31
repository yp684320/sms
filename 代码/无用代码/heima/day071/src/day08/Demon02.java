package day08;

public class Demon02 {
    public static void main(String[] args) {
     //创建字符串对象
        String s = "helloworld";
        //获取字符串的长速度,其实也就是字符个数
        System.out.println(s.length());
        System.out.println("-----");
        //将指定的字符串连接到该字符串的末尾
        String s1 = "helloworld";
        String s2 =s1.concat("**heima");
        System.out.println(s2);
        //获取指定索引出的字符
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(1));
        //获取字符串对象中第一次出现的索引,没有返回-1
        System.out.println(s.indexOf("h"));
        System.out.println(s.indexOf("l"));
        System.out.println("---");
        //从start开始截取字符串到字符串结尾
        System.out.println(s.substring(0));
        System.out.println(s.substring(8));
        //从start到end截取字符串,含start不含end
        System.out.println(s.substring(0,s.length()));
        System.out.println(s.substring(4,8));



    }
}