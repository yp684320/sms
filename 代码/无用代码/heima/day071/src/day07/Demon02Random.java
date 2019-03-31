package day07;

import java.util.Random;

//获取1--n之间的随机数,包含n
//创建Random对象
//获取1-n之间的随机数,变量名.nextInt(n),范围是0包括--10不包括
//输出数据
public class Demon02Random {
    public static void main(String[] args) {
        int n = 10;
        Random r = new Random();
        int a = r.nextInt(n)+1;
        System.out.println(a);
    }
}
