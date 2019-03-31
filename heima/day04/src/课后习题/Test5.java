package 课后习题;

import java.util.HashMap;
import java.util.Map;

/*七、有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，
将第一个数组元素作为key，
第二个数组元素作为value存储到Map集合中。
如{黑龙江省=哈尔滨, 浙江省=杭州, …}。*/
public class Test5 {
    public static void main(String[] args) {
        //创建俩个数组
        String[] s1 = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] s2 = {"哈尔滨","杭州","南昌","广州","福建"};
        //遍历数组
       /* for (String str: s1) {
            System.out.println(str);
        }
        for (String str1 : s2) {
            System.out.println(str1);
        }*/
        //创建一个Map集合
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(s1[i],s2[i]);
        }

        System.out.println(map);
    }

}
