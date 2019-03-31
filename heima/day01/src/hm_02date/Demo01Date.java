package hm_02date;
//public Date() ：分配Date对象并初始化此对象，以表示分配它的时间（精确到毫秒
//public Date(long date) ：分配Date对象并初始化此对象，
// 以表示自从标准基准时间（称为“历元 （epoch）”，
// 即1970年1月1日00:00:00 GMT）以来的指定毫秒数。
import java.util.Date;

public class Demo01Date {
    public static void main(String[] args) {
        //创建日期对象,把当前的时间
        System.out.println(new Date());
        //创建日期对象,把当前的毫秒值转成日期对象
        System.out.println(new Date(100L));
    }
}
