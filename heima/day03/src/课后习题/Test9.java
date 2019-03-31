package 课后习题;
/*Collectionsd的使用,它用于排序,有俩种格式
      1,Collection.sort(list)默认规则排序
      2,Collection.sort(list,new Comparator
      public static <T> void sort(List<T> list，Comparator<? super T> ) :将集合中元素按照指定规则排 序。


* */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*练习九：Collections工具类使用
九、ArrayList集合中有如下内容： {33,11,77,55}，使用Collections.sort()对ArrayList集合中的数据进行排序，并打印出排序后的结果。
*/
public class Test9 {
    public static void main(String[] args) {
        //创建一个ArrayList集合
        ArrayList<Integer> list = new ArrayList<>();
        //集合里添加元素
        list.add(33);
        list.add(11);
        list.add(77);
        list.add(55);
        System.out.println(list);
        //使用Collections.sort对集合排序
        Collections.sort(list);
        System.out.println(list);

    }
}
