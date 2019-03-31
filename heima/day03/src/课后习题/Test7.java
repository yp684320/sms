package 课后习题;

import java.util.ArrayList;

/*练习七：List集合元素替换
七、向list集合添加姓名{张三,李四,王五,二丫,钱六,孙七},将二丫替换为王小丫。
*/
public class Test7 {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("二丫");
        list.add("钱六");
        list.add("孙七");
        //遍历集合,获取二丫处的索引
        for (int i = 0;i < list.size();i++) {
            if (list.get(i).equals("二丫")) {
                list.set(i,"王小丫");
            }
        }
        System.out.println(list);
    }
}
