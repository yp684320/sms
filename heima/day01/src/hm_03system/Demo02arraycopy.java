package hm_03system;

import java.util.Arrays;

/*public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) ：
将 数组中指定的数据拷贝到另一个数组中。
*/
public class Demo02arraycopy {
    public static void main(String[] args) {
        int[] src = new int []{1,2,3,4,5};
        int[] dest = new int []{5,6,7,54,7};
        System.arraycopy(src,1,dest,0,3);
        String s1 = Arrays.toString(src);
        String s2 = Arrays.toString(dest);
       // System.out.println(s1);
        System.out.println(s2);

    }
}
