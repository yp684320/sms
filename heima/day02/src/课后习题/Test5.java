package 课后习题;

import java.util.ArrayList;

/*
* 练习五：Collection集合contains()方法使用
五、定义一个方法listTest(ArrayList<String> al, String s),要求使用contains()方法判断al集合里面是否包含s。
*/
public class Test5 {
    public static void main(String[] args) {
        //创建一个ArrayList<string>集合
        ArrayList<String> list = new ArrayList<>();
        //集合里添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(listTest(list,"jav"));
    }
    public static boolean listTest(ArrayList<String> al , String s){

        if (al.contains(s)) {
            return true;
        }
        else{
            return false;
        }

    }
}
