package hm_04diancai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//点菜/*模拟点菜系统.
//     1.点菜 -- 录入菜品编号 ,将某菜品添加集合中
//     2.算账 -- 把所有菜单中的金额累和.
//
//
//     实现步骤:
//     1.定义类 -- 菜
//           菜名/ 编号 / 价格
//     2. main中, 点菜
//            把菜品的对象,添加到一个集合中
//     3. 算账*/
public class Test {
    public static void main(String[] args) {
        //创建一个菜单集合
        ArrayList<Caidan> list = new ArrayList<>();
        //创建一个Caidan对象并赋值菜名,序号,价格
        Caidan c1 = new Caidan("北京烤鸭", "1", 198);
        Caidan c2 = new Caidan("拍 黄 瓜", "2", 28);
        Caidan c3 = new Caidan("清蒸鲤鱼", "3", 188);
        Caidan c4 = new Caidan("炖 排 骨", "4", 158);
        //菜单集合里添加菜品
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        System.out.println("===========菜单============");
        //遍历集合
        for(Caidan caidan : list){
            System.out.println(caidan);
        }
        System.out.println("==============================");
         //键盘录入菜品id
        //创建集合
        ArrayList<Caidan> str = new ArrayList<>();
        //创建Scanner类
        Scanner sc = new Scanner(System.in);
        //用while循环进行点菜
        //输入"0"表示点菜结束,跳出
        while (true) {
            System.out.println("请输入一个菜品编号");
            String id = sc.next();
            //判断0,跳出循环
            if ( "0".equals(id)){
                 break;}
                 //从菜品中挑出匹配的id,存入str集合中
            for (Caidan caidan : list) {
                String c_id = caidan.getId();
                if (id.equals(c_id)) {
                    str.add(caidan);
                }
            }
            System.out.println(str);
        }
       // System.out.println(str);
        //计算金额
        //遍历str集合  获取菜品价格  累加
        int num = 0;
        for(Caidan c :str){
            int price = c.getPrice();
            num += price;
        }
        System.out.println(num);
    }
}