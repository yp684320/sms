package hm_02date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*由于DateFormat为抽象类，不能直接使用，
所以需要常用的子类 java.text.SimpleDateFormat 。
这个类需要一个 模式（格式）来指定格式化或解析的标准。
构造方法为：
public SimpleDateFormat(String pattern) ：
用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
参数pattern是一个字符串，代表日期时间的自定义格式。
DateFormat类的常用方法有：
public String format(Date date) ：将Date对象格式化为字符串。
 public Date parse(String source) ：将字符串解析为Date对象。
*/
public class Demo02DateFormat {
    public static void main(String[] args) throws ParseException {
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //将当前日期转换为字符串
        String s = df.format(new Date());
        System.out.println(s);
        System.out.println("=========");
        //将字符串转换为日期对象
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date d = df1.parse("2018/04/03 10:30:20");
        System.out.println(d);


    }
}

