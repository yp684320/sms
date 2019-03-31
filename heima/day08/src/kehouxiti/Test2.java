package kehouxiti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*	练习二：Function接口使用
1.	使用lambda表达式分别将以下功能封装到Function对象中
a)	求Integer类型ArrayList中所有元素的平均数
b)	将Map<String,Integer>中value存到ArrayList<Integer>中
2.	已知学生成绩如下
姓名	成绩
岑小村	59
谷天洛	82
渣渣辉	98
蓝小月	65
皮几万	70
3.	以学生姓名为key成绩为value创建集合并存储数据，使用刚刚创建的Function对象求学生的平均成绩
*/
public class Test2 {
    public static void main(String[] args) {
       /* Function<ArrayList<Integer>, Integer> f = new Function<>() {
            @Override
            public Integer apply(ArrayList<Integer> list) {
                int sum = 0;
                for (Integer i : list) {
                    sum += i;
                }
                return sum /list.size();
            }
        };*/
       // a)	求Integer类型ArrayList中所有元素的平均数
        Function<ArrayList<Integer>, Integer> f1=  list-> {
                int sum = 0;
                for (Integer i : list) {
                    sum += i;
                }
                return sum /list.size();
        };
        // b)	将Map<String,Integer>中value存到ArrayList<Integer>中
       /* Function<Map<String,Integer>, ArrayList<Integer>> f2 = new Function<>() {
            @Override
            public ArrayList<Integer> apply(Map<String, Integer> map) {
                ArrayList<Integer> list = new ArrayList<>();
                for (String s : map.keySet()) {
                    int i = map.get(s);
                    list.add(i);
                }
                return list;
            }
        };*/
        Function<Map<String,Integer>, ArrayList<Integer>> f2 =
         (Map<String, Integer> map)-> {
               /* ArrayList<Integer> list = new ArrayList<>();
                for (String s : map.keySet()) {
                    int i = map.get(s);
                    list.add(i);
                }
                return list;*/
             Collection<Integer> values = map.values();
             ArrayList<Integer> list = new ArrayList<>();
             list.addAll(values);
             return list;
         };
        //创建Map集合
        Map<String, Integer> map = new HashMap<String,Integer>();
        //集合里添加元素
        map.put("岑小村",59);
        map.put("谷天洛",82);
        map.put("渣渣辉",98);
        map.put("蓝小月",65);
        map.put("皮几万",70);
        //求学生的平均成绩
        Integer avg = f2.andThen(f1).apply(map);
        System.out.println("学生的平均成绩为:"+ avg);
    }
}