package 斗地主;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*准备牌
   1. 定义Card 类  属性: 花色/点数
   2. 保存 map中
      id - Card
      1 -  大王
      2 -  小王
      3 -  ♠2
      4 -  ♥2
      5 -  ♣2
      6 -  ♦2
      7 -  ♠A
      ...
      54 - ♦3
   3. 洗牌
        Collections.shuffle(list)  洗 id的list
   4. 发 id List , 分成四份
       三份是玩家的id  -- 17
       一份底牌id      -- 3
   5. id 排序  Collections.sort(list)
   6. 通过id 获取牌*/
public class Test {
    //创建一个HashMap集合
      static HashMap<Integer, Card> map = new HashMap<>();
    public static void main(String[] args) {

        //创建花色数组
        String[] hs = "♥-♣-♠-♦".split("-");
        //创建点数数组
        String[] ds = "2-A-k-Q-J-10-9-8-7-6-5-4-3".split("-");
        int id = 3;
        // 遍历数组
        for (String d : ds) {
            String str = d;
            for (String h : hs) {
                String str1 = h;
                //创建Card对象
                Card card = new Card(d,h);
             map.put(id ++,card);
            }
        }
        //添加王牌
        map.put(1,new Card("大","王"));
        map.put(2,new Card("小","王"));
        System.out.println(map);
        //获取id的list  1- 54 集合
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 54 ; i++) {
            list.add(i);
        }
        //洗牌
        Collections.shuffle(list);
        System.out.println(list);
        //发牌   发id, 把id 取出17张 , 保存到一个新集合中
        //创建三个玩家集合和一个底牌集合  调用发牌方法
        ArrayList<Integer> p1ay1_id = fpId(list);
        ArrayList<Integer> play2_id = fpId(list);
        ArrayList<Integer> play3_id = fpId(list);
        System.out.println(list);
        /*
         id 转换 Card
         */
        ArrayList<Card> play1_card = idToCard(p1ay1_id);
        ArrayList<Card> play2_card = idToCard(play2_id);
        ArrayList<Card> play3_card = idToCard(play3_id);
        ArrayList<Card> dp_card = idToCard(list);
        System.out.println(play1_card);
        System.out.println(play2_card);
        System.out.println(play3_card);
        System.out.println(dp_card);
    }/*id -- card , 获取map中元素 , 但是 map 之前定义main方法中, 所以必须传递才能用.
     传递非常麻烦 ,  可以采用 成员变量的方法 , 也可以进行访问.
     hashMap ,由局部位置 ,提升 成员位置. 使用static 修饰.*/
    public static ArrayList<Card> idToCard(ArrayList<Integer> play1_id){
        //创建一个新集合
        ArrayList<Card> cards = new ArrayList<>();
        //遍历老集合
        for (int i = 0; i < play1_id.size(); i++) {
             Integer id = play1_id.get(i);
             Card card = map.get(id);
             cards.add(card);
        }
        return cards;
    }
    /*
     从list 中, 获取17张 , 保存新的集合中 ,并返回新集合
     */
    public static ArrayList<Integer> fpId(ArrayList<Integer> list){
        //创建玩家集合
        ArrayList<Integer> play = new ArrayList<>();
        /*1.遍历 老集合
           注意:  1.循环次数 17次
                 2. 移除老集合元素
                 3. remove(i) -- i 越来越大, 牌数越来越少 , 可能越界 ( 剩最后10张牌)
                    remove(0), 把首张牌,发给玩家.
         */
        for (int i = 0; i < 17; i++) {
            Integer id = list.remove(0);
            //添加到新集和
            play.add(id);
        }
        //排序
        Collections.sort(play);
        return play;
    }
}
