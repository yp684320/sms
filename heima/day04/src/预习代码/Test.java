package 预习代码;

import java.util.HashMap;
import java.util.Scanner;

/*计算一个字符串中每个字符出现次数。*/
public class Test {
    public static void main(String[] args) {
        //创建一个Scanner类 并接受数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = sc.next();
        //创建一个Hashmap集合  存储字符 以及出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断 该字符 是否在键集中
            if (!map.containsKey(c)) {//说明这个字符没有出现过
                map.put(c, 1);
            }else{
                //获取之前的次数
                Integer count = map.get(c);
                //再次存入 更新
                map.put(c,++count);
            }
        }
        System.out.println(map);
    }
}