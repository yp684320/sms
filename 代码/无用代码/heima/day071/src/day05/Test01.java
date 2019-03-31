package day05;
/*- 模拟大乐透号码：
  - 一组大乐透号码由10个1-99之间的数字组成
  - 定义方法，参数列表为int数组
  - 方法内打印大乐透号码信息
- 代码实现，效果如图所示：

- 开发提示：
  - 使用数组保存录入的号码
*/
public class Test01 {
    public static void main(String[] args) {
        //创建数组
        int[] arr = {10, 20, 30, 40, 50, 60, 66, 70, 80, 99};
      //  调用方法
        printNum(arr);//调用方法时参数里只调用数组名字arr
    }
//定义方法，参数列表为int数组
    public static void printNum(int[] arr) {
        System.out.println("您的大乐透号码为:");
        //遍历数字存入数组
        for (int i = 0;i < arr.length;i++) {
            System.out.print(arr[i]+",");
        }
    }
}