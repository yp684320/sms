package day12;


import java.util.Calendar;
import java.util.Date;


public class Demo02Calendar {
    public static void main(String[] args) {
        //创建Calendar对象
        Calendar cal = Calendar.getInstance();
        //获取年
        int year = cal.get(Calendar.YEAR);
        //设置年份为2020年
        cal.set(Calendar.YEAR,2020);
        //将年份修改为2000年
        cal.add(Calendar.YEAR,-20);
        //将日历对象转换为日期对象
        Date d = cal.getTime();

    }
}
