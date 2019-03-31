package hm_05ceshi;

import java.util.Arrays;

/*
* 练习八：System类arraycopy方法的使用
现有一个字符数组{'i','t','c','a','s','a'}，
请使用System类中的arraycopy()方法在控制台输出“itcast”。
（提示：将[1]号数组元素复制到最后位置并覆盖原有元素。）
*/
public class Test08 {
    public static void main(String[] args) {
        //创建一个数组
        char[] c = {'i','t','c','a','s','a'};
        int a = c.length;
        System.arraycopy(c,1,c,a-1,1);
       /* for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }*/
        System.out.println(c);


    }
}
