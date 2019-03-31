package hm_03system;
/*public static long currentTimeMillis() ：返回以毫秒为单位的当前时间。
public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) ：
将 数组中指定的数据拷贝到另一个数组中。
 * */
public class Demo01currentTimeMillis {
    public static void main(String[] args) {
        //获取当前时间毫秒值
        System.out.println(System.currentTimeMillis());
        //计算程序运行时间
        long start = System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时: "+(end - start));
    }
}
