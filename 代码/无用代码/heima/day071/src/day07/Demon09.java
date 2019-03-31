package day07;

import java.util.ArrayList;

/*定义以指定格式打印集合的方法(ArrayList)类型作为参数,
使用[]扩起集合,使用","隔开每个元素.格式参照[元素,元素,元素]
1,创建Arraylist类型对象,并添加元素
2,创建ArrayList作为参数的方法
3,调用方法并打印输出

*/
public class Demon09 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("李飞");
        list.add("李华");
        list.add("冯奎");
        printArrayList(list);
    }
    public static void printArrayList(ArrayList<String> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(s + ",");
            } else {
                System.out.print(s);
            }
        } System.out.println("]");
    }
}