package day08;

import java.util.ArrayList;

/*- 筛选字符串。
  - 定义ArrayList集合，存入多个字符串。
  - 长度大于5的字符串，打印删除后的集合。
- 代码实现，效果如图所示：
*/
public class Test05 {
    public static void main(String[] args) {
        //创建ArrayList集合
        ArrayList<String> list = new ArrayList<>();
        //集合里添加元素
        list.add("bca");
        list.add("dadfa");
        list.add("dddaaa");
        list.add("你好啊");
        list.add("我来了");
        list.add("你干嘛呢");
        list.add("别跑啊");
        System.out.println("源字符串:"+list);
        //遍历集合
        for(int i = 0;i < list.size();i ++){
            //获取当前元素
            String s = list.get(i);
            //判断长度大于5 的字符串,并删除
            if (s.length() > 5){
                 list.remove(s);
                 i --;
            }
        }

        System.out.println(list);

    }

}