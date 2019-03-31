package 斗地主;

import java.util.ArrayList;
import java.util.Collections;

/*4.1 案例介绍
按照斗地主的规则，完成洗牌发牌的动作。
具体规则： 使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，后三张留作底牌。
4.2 案例分析
准备牌： 牌可以设计为一个ArrayList,每个字符串为一张牌。
每张牌由花色数字两部分组成，我们可以使用花色 集合与数字集合嵌套迭代完成每张牌的组装。
牌由Collections类的shuﬄe方法进行随机排序。
发牌 :将每个人以及底牌设计为ArrayList,
将后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
看牌 直接打印每个集合。 */
public class Demo {
    public static void main(String[] args) {
        //准备牌
        //创建一个ArrayList集合  用来存储puke
        ArrayList<String> puke = new ArrayList<>();
        //创建一个ArrayList集合   存储花色
        ArrayList<String> hs = new ArrayList<>();
        //添加花色到集合
        hs.add("黑桃");
        hs.add("红桃");
        hs.add("梅花");
        hs.add("方片");
        //创建一个ArrayList集合   存储数字
        ArrayList<String> sz = new ArrayList<>();
        //添加数字到集合
        for (int i = 2; i <= 10; i++) {
            sz.add(i+"");//i+" " 一个数字与一个字符串相加是一个字符串
        }
        sz.add("J");
        sz.add("Q");
        sz.add("K");
        sz.add("A");
        //System.out.println(sz);
        //puke里每一张都是由花色和数字组成
        for (String s1 : hs) {
            for (String s2 : sz){
                String card = s1 + s2;
               //把每一张牌添加到puke集合里
                puke.add(card);
            }
        }
        puke.add("大王");
        puke.add("小王");
       // System.out.println(puke);
        //洗牌
        Collections.shuffle(puke);
        //发牌
        //创建三个集合  存储三个玩家的牌
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        ArrayList<String> a3 = new ArrayList<>();
        //创建就一个集合  存储底牌
        ArrayList<String> dipai = new ArrayList<>();
        //遍历puke 必须知道索引
        for (int i = 0 ;i < puke.size();i ++) {
            //留出三张  添加到dipai
            if (i >= 51) {//存储到dipai
                dipai.add(puke.get(i));
            } else if (i % 3 == 0) {
                a1.add(puke.get(i));
            } else if (i % 3 == 1) {
                a2.add(puke.get(i));
            } else {
                a3.add(puke.get(i));

            }

        }//打印输出
       System.out.println("张三"+a1);
        System.out.println("李四"+a2);
        System.out.println("王五"+a3);
       System.out.println("底牌"+dipai);
    }
}
