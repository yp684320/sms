package 课后习题;

import java.util.ArrayList;
import java.util.Collection;

/*练习四：Collection集合集合转数组
四、定义一个集合，并把集合(集合里面的元素是Integer)转成存有相同元素的数组，
并将结果输出在控制台。（可以使用Object[]数组类型接收转换的数组）
*/
public class Test4 {
    public static void main(String[] args) {
        //创建一个Integer类集合
        ArrayList<Integer> list = new ArrayList<>();
        //集合里添加元素
        list.add(100);
        list.add(200);
        list.add(300);
        //把集合转变为数组
        Object[] obj = list.toArray();
        //遍历;集合并输出
        for (int i = 0;i < obj.length;i ++) {
            System.out.println(obj[i]);
        }

    }
}
