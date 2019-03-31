package 课后习题;


import java.util.ArrayList;

/*练习三：Collection集合数组转集合
三、定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，并返回。
*/
public class Test3 {
    public static void main(String[] args) {
        //创建一个 int数组
        int[] arr = {1,3,4,5,6};
        ArrayList<Integer> list = listTest(arr);
        System.out.println(list);

    }
    public static ArrayList<Integer> listTest(int[] arr){
        //创建一个存放Integer类的集合
        ArrayList<Integer> list = new ArrayList<>();
        //用增强for遍历数组,把元素添加到集合中
        for(int a : arr){
            list.add(a);
        }
        return list;
    }
}
