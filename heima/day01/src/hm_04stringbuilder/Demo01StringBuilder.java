package hm_04stringbuilder;
/*StringBuilder常用的方法有2个：
public StringBuilder append(...) ：添加任意类型数据的字符串形式，并返回当前对象自身。
 public String toString() ：将当前StringBuilder对象转换为String对象*/
public class Demo01StringBuilder {
    public static void main(String[] args) {
        //创建对象
        StringBuilder builder = new StringBuilder();
        //可以添加任何类型
        builder.append("Hello");
        builder.append(100);
        builder.append(true);
        //将StringBuilder转为字符串
        String s = builder.toString();
        System.out.println(s);
        String s2 = builder.append(20).append(true).append("Hello").append(340).toString();
        System.out.println(s2);
    }

}
