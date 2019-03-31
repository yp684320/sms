package 课后习题;

import java.util.ArrayList;

/*练习六：Collection集合isEmpty()方法的使用
六、定义一个方法listTest(ArrayList<String> al), 要求使用isEmpty()判断al里面是否有元素。
*/
public class Test6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("8");
        System.out.println(listTest(list));
    }
    public static boolean listTest(ArrayList<String> al){

        if (al.isEmpty()) {
            return true;

        }
        return false;
    }
}
