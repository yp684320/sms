package hm01_yichang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        try {
            Date date = format.parse("2018-04-03");
            System.out.println("程序正常");
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("程序异常");
        }
    }



}