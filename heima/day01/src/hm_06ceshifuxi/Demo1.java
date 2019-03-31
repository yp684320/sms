package hm_06ceshifuxi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//六、使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日
/*1,先把2018-03-04转化为Date

* */
public class Demo1 {
    public static void main(String[] args) throws ParseException {
        //创建一个SimpleDateFor类
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //将当前字符串转化为日期
        Date d = df.parse("2018-03-04");
        System.out.println("----------");
        //创建一个SimpleDateFormat类
        DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日");
        //将日期转化为字符串
        String s = df1.format(d);
        System.out.println(s);
    }
}
