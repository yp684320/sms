package day05;

import java.util.Arrays;

/*- 定义sym方法，判断数组中的元素值是否对称.
- 代码实现，效果如图所示：

- 开发提示：
  - 数组中元素首尾比较。
*/
public class Test03 {
    public static void main(String[] args) {
        //定义数组获取随机数
        int[] arr1={1,2,3,4,3,2,1,};
        int[] arr2={1,2,3,4,5,2,1,};
        System.out.println(Arrays.toString(arr1)+"是否对称:"+sym(arr1));
        System.out.println(Arrays.toString(arr2)+"是否对称:"+sym(arr2));


    }
    public static boolean sym (int[] arr){
        //遍历数组
        for (int start = 0 , end = arr.length-1; start <= end ; start++ ,end--) {
            if(arr[start]!=arr[end]){
                return false;
            }
        }
        return true;
    }
}
