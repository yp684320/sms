package 课后习题;
/*十二、编写一个泛型方法，接收一个任意引用类型的数组，并反转数组中的所有元素*/
public class Test11 {
    public static void main(String[] args) {
      Integer[] a ={1,2,3,4,5,6};
      method(a);
    }
    //编写一个泛型方法
    public static <E> void method(E[] e){
        //元素反转
        for(int min = 0,max = e.length-1;min < max;min ++,max --){
            E temp = e[min];
            e[min] = e[max];
            e[max] = temp;
        }
        for (int i = 0; i < e.length; i++) {
            System.out.print(e[i]+" ");

        }
    }
}
