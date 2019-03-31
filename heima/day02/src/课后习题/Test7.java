package 课后习题;

import java.util.ArrayList;

/*练习八：Collection集合返回首次出现索引
八、定义一个方法listTest(ArrayList<Integer> al, Integer s)，要求返回s在al里面第一次出现的索引，如果s没出现过返回-1。
*/
public class Test7 {
    public static void main(String[] args) {
//创建一个集合
        ArrayList<Integer> list = new ArrayList<>();
        //添加元素
        list.add(2);
        list.add(24);
        list.add(28);
        System.out.println(listTest(list,2));
    }
    public static int listTest(ArrayList<Integer> al, Integer s){
        //遍历集合
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
