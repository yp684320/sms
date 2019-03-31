package 课后习题;

import java.util.HashSet;
import java.util.Random;

/*练习十二：HashSet的使用
十二、双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
红色球号码从1—33中选择；蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）
*/
public class Test12 {
    public static void main(String[] args) {
        //1,创建一个Random类
        Random r = new Random();
        //2,随机生成一个蓝色号码
        int a = r.nextInt(16)+1;
        //3,创建一个HashSet集合
        HashSet<Integer> set = new HashSet<>();
        //4,遍历6个红色号码
        for (int i = 0; i < 6 ; i++) {
            int b = r.nextInt(33)+1;
            //5,把号码添加到集合里
            set.add(b);
        }
        while (set.size() < 6) {
            // 6,球数量小于6个就产生一个红球.添加到set中
            //7,如果产生重复号码，往HashSet里添加不进去，所以会再次生成号码
            int num = r.nextInt(33) + 1;
            set.add(num);
        }
        //8,打印输出
        System.out.println("双色球中奖号码为: ");
        System.out.println("蓝色号码为:"+a);
        System.out.println("红色号码为:"+set);
    }
}
