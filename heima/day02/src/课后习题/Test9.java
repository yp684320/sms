package 课后习题;

import java.util.ArrayList;
import java.util.Random;

/*练习十：Collection集合练习
十、产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
*/
public class Test9 {
    public static void main(String[] args) {
        //创建一个长度为10的数组
        int[] arr = new int[10];
        //创建一个Random类对象
        Random r = new Random();
        //获取这十个数字
        for (int i = 0; i < arr.length; i++) {
           arr[i] = r.nextInt(100)+1;
           // System.out.print(arr[i]+" ");
        }

        //创建一个集合
        ArrayList<Integer> list = new ArrayList<>();
        //遍历数组
        for (Integer integer : arr) {
            //System.out.println(integer);
            //判断大于10 的数字
            if (integer >= 10) {
                //添加到集合
                list.add(integer);
            }

        }
        System.out.println("大于等于10的数字为: "+ list);

    }
}
