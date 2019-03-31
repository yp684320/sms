package 课后习题;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*练习十：LinkedList使用
十、已知数组存放一批QQ号码，QQ号码最长为11位，最短为5位String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}。
将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，将list中所有元素分别用迭代器和增强for循环打印出来
*/
public class Test10 {
    public static void main(String[] args) {
        String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
        //创建LinkedList集合
        List<String> list = new LinkedList<>();
        //遍历数组
        for (int i = 0;i < strs.length;i ++) {
            //判断集合中是否存在这个元素
            if (!list.contains(strs[i])) {
                //如果不存在就添加到集合里
                list.add(strs[i]);
            }
        }
        //System.out.println(list);
        //用迭代器遍历集合并打印
        Iterator<String > it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.print(s+" ");
        }
        //用增强for
        for (String a : list) {
            System.out.print(a+" ");
        }
    }
}
