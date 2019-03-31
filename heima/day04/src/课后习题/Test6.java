package 课后习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*八、定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。*/
public class Test6 {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add("abc");
        list.add("bcd");
        System.out.println(list);
        //创建一个HashMap集合
        HashMap<Character, Integer> map = new HashMap<>();
        //遍历集合
        for (String s : list) {
            char[] ch = s.toCharArray();
            // 遍历数组
            for (int i = 0; i < ch.length; i++) {
                //获取每个字符  在map集合中查找
                Integer num = map.get(ch[i]);
                if (num == null) {//如果为空,说明该字符第一次出现在map集合里,值记为1
                    map.put(ch[i],1);

                } else {//如果之前有了,把字符的次数+1
                    map.put(ch[i],num + 1);
                }
            }
            System.out.println(map);
        }

    }
}
