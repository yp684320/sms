package hm_05ceshi;

import java.util.Calendar;

public class Test7 {
    public static void main(String[] args) {
       //创建Calendar类
       Calendar c = Calendar.getInstance();
       //设置年
        c.set(Calendar.YEAR,2018);
        //设置月
        c.set(Calendar.MONTH,1);
        //设置日
        c.set(Calendar.DAY_OF_MONTH,14);
        //获取年
        int year = c.get(Calendar.YEAR);
        //获取月
        int month = c.get(Calendar.MONTH)+1;
        //获取日
        int day = c.get(Calendar.DAY_OF_MONTH);
        //获取周几
       // int week = c.get(Calendar.DAY_OF_WEEK)-1;
       // System.out.println(year+"年"+month+"月"+day+"日是星期"+week);
        char week = getWeek(c.get(Calendar.DAY_OF_WEEK));
        //输出结果
        System.out.println(year+"年"+month+"月"+day+"日是星期"+week);
    }
    //定义方法,获取星期汉字
    public static char getWeek(int a){
        char [] c = {' ','日','一','二','三','四','五','六'};

             return c[a];
    }

}

