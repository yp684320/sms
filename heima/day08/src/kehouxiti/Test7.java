package kehouxiti;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*	练习九：Stream综合练习

1、现将两个榜单中的影片名，分别按排名顺序依次存入两个ArrayList集合
2、通过流的方式
	1）打印全球影片排行榜中的前三甲影片名
	2）打印华人影片排行榜中倒数5名的影片名
	3）将两个排行榜中的前5名挑出来共同存入新的集合
	4）定义电影Film类，以影片名为name创建Film对象并保存至集合
*/

public class Test7 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("<<教父>>");
        list1.add("<<肖申克救赎>>");
        list1.add("<<辛德勒的名单>>");
        list1.add("<<公民凯恩>>");
        list1.add("<<卡萨布兰卡>>");
        list1.add("<<交付续集>>");
        list1.add("<<七武士>>");
        list1.add("<<星球大战>>");
        list1.add("<<美国美人>>");
        list1.add("<<飞越疯人院>>");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("<<霸王别姬>>");
        list2.add("<<大闹天宫>>");
        list2.add("<<鬼子来了>>");
        list2.add("<<大话西游>>");
        list2.add("<<活着>>");
        list2.add("<<饮食男女>>");
        list2.add("<<无间道>>");
        list2.add("<<天书奇谭>>");
        list2.add("<<哪吒闹海>>");
        list2.add("<<春光乍泄>>");
        //1）打印全球影片排行榜中的前三甲影片名
        list1.stream().limit(3).forEach(System.out::println);
        System.out.println("========");
        //2）打印华人影片排行榜中倒数5名的影片名
        list2.stream().skip(5).forEach(System.out::println);
        System.out.println("========");
        //3）将两个排行榜中的前5名挑出来共同存入新的集合
        Stream<String> stream1 = list1.stream().limit(5);
        Stream<String> stream2 = list2.stream().limit(5);
        //List<String> list = Stream.concat(stream1, stream2).collect(Collectors.toList());
        //4）定义电影Film类，以影片名为name创建Film对象并保存至集合
       /* List<Film> list3 = Stream.concat(stream1, stream2).map(Film::new).collect(Collectors.toList());
        for (Film f : list3) {
            System.out.println(f);
        }*/
        Stream.concat(stream1, stream2).map(Film::new).collect(Collectors.toList()).forEach(System.out::println);

    }
}
