package day05;
/*- 统计高于平均分的分数有多少个。
  - 定义数组[95, 92, 75, 56, 98, 71, 80, 58, 91, 91]。
  - 定义getAvg方法，获取一个数组中的平均数
  - 在main内判断该数组高于平均分的有多少个

- 代码实现，效果如图所示：

*/
public class Test02 {
    public static void main(String[] args) {
        //定义数组获取随机分数
        int[] arr1 = {95, 92, 75, 56, 98, 71, 80, 58, 91, 91};
       // 获取平均分
        int getAvg = getAvg(arr1);
        //定义统计变量并赋值
        int count = 0;
        for(int i = 0;i < arr1.length;i ++) {
            if (arr1[i] > getAvg) {
                count++;
            }
        }
        System.out.println("高于平均分:"+getAvg+"的个数有"+count+"人");
    }
//定义方法获取数组中的平均数getAvg
    public static int getAvg(int[] arr){
            //定义统计变量并赋值
            int sum = 0;
            //遍历数组获取平均数
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum / arr.length;
        }
    }
