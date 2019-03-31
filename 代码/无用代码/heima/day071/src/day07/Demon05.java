package day07;

import java.util.ArrayList;

//ArrayLIst常用方法和遍历:
public class Demon05 {
    public static void main(String[] args) {
        /*//创建集合对象
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add("A");
        list.add("呵呵");
        list.add("890");
        //public E get(int index):返回指定索引出的元素
        System.out.println("get:"+list.get(0));
        System.out.println("get:"+list.get(1));
        System.out.println("get:"+list.get(2));
        System.out.println("-------");
        //public int size():返回集合中的元素的个数
         System.out.println("size:"+list.size());
        System.out.println("------");
         //piblic E remove(int index):删除指定位置的元素,返回被删除的元素
        System.out.println("remove:"+list.remove(1));
        for(int i = 0;i <list.size();i++){
            System.out.println(list.get(i));
        }*/
        //创建ArrayLidt集合对象
        ArrayList<String> list = new ArrayList<>();
        //集合中添加元素
        list.add("曹操");
        list.add("张飞");
        list.add("关于");
        //返回指定索引的元素
        System.out.println("get:"+list.get(0));
        System.out.println("get:"+list.get(1));
        System.out.println("get:"+list.get(2));
        //返回集合中的元素个数
        System.out.println("size:"+list.size());
        //删除指定位置的元素,返回被删除的元素
        System.out.println("remove:"+list.remove(1));
        //遍历集合
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
