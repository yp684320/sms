package yuxi;
/*类名--引用静态方法
由于在 java.lang.Math 类中已经存在了静态方法 random ，
所以当我们需要通过Lambda来调用该方法时,可以使 用方法引用 ,
写法是：
 */
import java.util.function.Supplier;

public class Demo03 {
    public static void printRanNum(Supplier<Double> sup){
        Double apply = sup.get();
        System.out.println(apply);
    }

    public static void main(String[] args) {
       printRanNum(Math ::random);

    }
}
