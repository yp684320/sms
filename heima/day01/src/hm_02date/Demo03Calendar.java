package hm_02date;

import java.util.Calendar;
import java.util.Date;

/*Calendar为抽象类，不能直接创建对象，而是通过静态方法创建，返回子类对象
public int get(int field) ：返回给定日历字段的值。
 public void set(int field, int value) ：将给定的日历字段设置为给定值。
  public abstract void add(int field, int amount) ：根据日历的规则，为给定的日历字段添加或减去指 定的时间量。
  public Date getTime() ：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。 Calendar类中提供很多成员常量，代表给定的日历字段
*/
public class Demo03Calendar {
    public static void main(String[] args) {
        //创建Calendar对象
        Calendar cal = Calendar.getInstance();
        //获取年
        int year = cal.get(Calendar.YEAR);
        System.out.println(year);
        //设置年份为2028年
        cal.set(Calendar.YEAR,2028);
        System.out.println(cal.get(Calendar.YEAR));
        //将年份修改为2008年
        cal.add(Calendar.YEAR,-20);
       System.out.println(cal.get(Calendar.YEAR));
        //将日历对象转换为日期对象
        Date d = cal.getTime();
        System.out.println(d);
    }
}
