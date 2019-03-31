package hm_05ceshi;

import java.util.Calendar;

public class Test07 {
    public static void main(String[] args) {
        //创建Calendar类
        Calendar c = Calendar.getInstance();
        //设置年,月,日;
        c.set(Calendar.YEAR,2018);
        c.set(Calendar.MONTH,1);
        c.set(Calendar.DAY_OF_MONTH,14);
        //获取年月日
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        //获取周
        int week= c.get(Calendar.DAY_OF_WEEK)-1;
        //定义以字符数组
        char [] ch = {'日','一','二','三','四','五','六'};
        System.out.println(year + "年"+month +"月"+day+"日是星期"+ch[week]);

    }
}