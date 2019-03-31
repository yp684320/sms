package 预习代码;

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        //创建Map对象
        HashMap<String,String> map= new HashMap<>();
        //添加元素到集合
        map.put("黄晓明","杨颖");
        map.put("孙俪","邓超");
        map.put("文章","马伊琍");
        System.out.println(map);
        System.out.println(map.remove("黄晓明"));
        System.out.println(map);
        System.out.println(map.get("文章"));



    }
}
