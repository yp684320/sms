package hm_05ceshi;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test6 {
    public static void main(String[] args) throws ParseException {
        //创建SimpleDateFormat对象,并输入规定的格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //用df调用parse(String str)方法
        Date date = df.parse("2018-03-04");
        //创建DateFormat对象,并输入规定的格式
        DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日");
        //用df1调用format(Date date)方法
        String s = df1.format(date);
        System.out.println(s);
    }
}




