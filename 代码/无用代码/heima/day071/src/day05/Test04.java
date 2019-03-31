package day05;

import java.util.Arrays;

/*- 定义equals方法，比较数组内容是否完全一致。
- 代码实现，效果如图所示：

- 开发提示：
  - 长度一致，内容一致，定义为完全一致。
*/
public class Test04 {
    public static void main(String[] args) {
        int[] arr1 ={1,2,3,4,3,2,1};
        int[] arr2 ={1,2,3,4,3,2,1};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println("是否一致:"+ equals(arr1,arr2));
    }
    public static boolean equals(int[] arr1,int[] arr2){
        //判断长度是否相等
        if(arr1.length!=arr2.length){
            return false;
        }
        //判断内容是否相等
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}

