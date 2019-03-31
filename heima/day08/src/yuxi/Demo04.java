package yuxi;

import java.util.ArrayList;
import java.util.List;

public class Demo04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三丰");
        list.add("张强");
        /*for (String name : list) {
            System.out.println(name);
        }*/
        List<String> zhangList = new ArrayList<>();
        for (String name: list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }

        }
       // System.out.println(zhangList);
        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length()==3) {
                shortList.add(name);
            }
        }
       /* for (String name : shortList) {
            System.out.println(name);
        }*/
        list.stream().filter(s->s.startsWith("张"))
                     .filter(s->s.length()==3)
                     .forEach(System.out::println);
    }
}
