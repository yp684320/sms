package 课后习题;

import java.util.Arrays;



/*十一、编写一个泛型方法，实现任意引用类型数组指定位置元素交换。*/
public class Test10 {
    public static void main(String[] args) {
        //创建一个int数组
        /*int[] a = {10,20,30,40,50,60};

       //char[] b = new char[6];
        //把int数组1号索引位置的元素拷贝到索引为5的位置
        System.arraycopy(a,0,a,5,1);
        //遍历输出
        for (int i = 0;i < a.length; i ++) {
            System.out.print(a[i]+" ");
        }*/
       Integer[] c ={10,20,30,40,50,60};
       method(c,0,5);


    }
    //定义泛型方法
    public static <E> void method(E[] e,int a ,int b){
        //元素互换
        E temp = e[a] ;
       e[a] = e[b];
       e[b]  = temp ;
        //遍历数组
        for (int i = 0; i < e.length ; i++) {
            //打印输出
            System.out.print(e[i]+" ");
        }
    }


}