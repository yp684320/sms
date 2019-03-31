package hm_05ceshi;

import static java.lang.System.currentTimeMillis;

/*练习九：StringBuilder类的使用
九、请使用代码实现
分别使用String的 += 和StringBuilder的append方法对字符串做100000次拼接，
计算String拼接100000次花费时间与StringBuilder拼接100000次所花费时间并打印。
*/
public class Test9 {
    public static void main(String[] args) {
        //获取运行前的时间
       long start1 =  System.currentTimeMillis();
       //计算出用String的拼接100000次的时间
        String s = "Hello";
        for (int i = 0; i < 100000; i++) {
             s += "World";

        }
        long end1 = System.currentTimeMillis();
        //System.out.println(end1-start1);
        long start2 = System.currentTimeMillis();

        //计算出StringBuilder拼接的时间
        //创建一个Stringbuilderd对象
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < 100000; i++) {
            sb.append("World");

        }
       /* String s2 = sb.toString();
        System.out.println(s2);*/
        long end2 = System.currentTimeMillis();

        System.out.println("时间差为: "+((end1-start1)-(end2-start2)));
    }
}
