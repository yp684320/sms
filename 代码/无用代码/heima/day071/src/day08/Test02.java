package day08;

import java.util.Scanner;

/*- 键盘录入QQ号码，验证格式的正确性。
  - 必须是5—12位数字。
  - 0不能开头。

- 代码实现，效果如图所示：

1,创建Scanner类,并接受数据
2,
*/
public class Test02 {
    public static void main(String[] args) {
        //  创建Scanner类,并接受数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个qq号");
        //定义一个字符串接受数据
        String qq = sc.next();
        boolean s = chekqq(qq);
        System.out.println("这个qq号码是否正确:"+s);
    }
    /*定义方法,方法名chekqq,参数String sc,返回值Boolean
     */
    public static boolean chekqq(String qq) {
        //用if语句判断字符串的长度
        if(qq.length() < 5 || qq.length() > 12 ){
            return false;
            //用if语句判断字符串的首位数字不能是0
        }if(qq.charAt(0) == '0'){
            return false;
        }
        //验证该字符串必须是0-9之间的数字
        //遍历字符串
        for(int i = 0 ;i < qq.length();i ++){
            char ch = qq.charAt(i);
            if (ch<'0'  || ch >'9'){
                return false;
            }
        }
        return true;
    }
}
