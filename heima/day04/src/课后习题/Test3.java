package 课后习题;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*五、请使用Map集合存储自定义数据类型Car做键，对应的价格做值。并使用keySet和entrySet两种方式遍历Map集合。*/
public class Test3 {
    public static void main(String[] args) {
        //创建一个HashMap集合
        HashMap<Car,Integer> map = new HashMap<>();
        //添加元素,
        map.put(new Car("宝马","黑色"),150);
        map.put(new Car("奔驰","白色"),180);
        map.put(new Car("凯迪拉克","红色"),170);
        //使用keyset遍历集合
        //获取keySet集合 快捷键 map.keySet().var  +  enter
        Set<Car> set = map.keySet();
        //遍历集合
        for (Car car : set) {
            System.out.println(car+"  "+map.get(car));
        }
        //用ertrySet遍历集合
        //或取enterySet集合  快捷键 map.entrySet().var  +  enter
        Set<Map.Entry<Car, Integer>> entries = map.entrySet();
        for (Map.Entry<Car, Integer> entry : entries) {
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
}
