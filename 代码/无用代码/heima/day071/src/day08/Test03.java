package day08;

import java.util.Scanner;

/*
- 字符串查找。
        - 键盘录入一个大字符串，再录入一个小字符串。
        - 统计小字符串在大字符串中出现的次数。

        - 代码实现，效果如图所示：
*/
public class Test03 {
    public static void main(String[] args) {
        //创建Scanner类,并接受数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串:");
        String big = sc.nextLine();
        System.out.println("请输入第二个字符串:");
        String small = sc.nextLine();
        //统计小字符串在大字符串中出现的次数。
        int count = getCount(big,small);
        System.out.println("小字符串"+small+",在大字符串中共出现"+count+"次");

    }
    /*
     * 方法功能：统计小字符串在大字符串中出现的次数
     * 参数：big 代表大字符串
     * 参数：small 代表小字符串
     * 返回值：小字符串在大字符串中出现的次数
     */
    public static int getCount(String big,String small){
        String r = big.replace(small,"");
        return (big.length()-r.length())/small.length();
    }
}
