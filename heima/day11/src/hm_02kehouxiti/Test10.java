package hm_02kehouxiti;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*项目根路径下有text.txt文件，内容如下：
	我爱黑马
	123456
利用IO流的知识读取text.txt文件的内容反转后写入text1.txt文件中，内容如下：
	123456
我爱黑马
*/
public class Test10 {
    public static void main(String[] args) throws IOException {
       //创建集合
        ArrayList<String> list= new ArrayList<>();
        //创建字符缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        //读取数据
        String len;
        while ((len = br.readLine())!= null) {
            System.out.println(len);
            list.add(len);
        }//关闭资源
        br.close();
        //反转集合中的元素
        Collections.reverse(list);
        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("text1.txt"));
        //写出数据
        //循环输出
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i));
            bw.newLine();
        }
       //关闭资源
        bw.close();


    }
}
