package hm_05ceshi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test5 {
    public static void main(String[] args) {
        //获取当前日期,将当前日期转换为字符串
        //DateFormat df = new SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
        //String s = df.format(new Date());
        //System.out.println(s);
        Date d = new Date();
        //System.out.println(d);
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
        String s = df.format(d);
        System.out.println(s);


    }
}
