package hm_01daima;
/*需求：写一个"框架"，不能改变该类的任何代码的前提下，
可以帮我们创建任意类的对象，并且执行其中任意方法
实现：
1. 配置文件  必须是properties类文件
2. 反射
步骤：
1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
2. 在程序中加载读取配置文件
3. 使用反射技术来加载类文件进内存
4. 创建对象
5. 执行方法*/
import org.junit.Test;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
/* 模拟框架 :
  1.准备配置文件, 是你使用的框架规定格式/规定名称 形参的文档.
  2.准备自己代码. User类
  3.根据你类的信息,填写配置文件.
  4.框架中代码, 根据你的配置, 去执行相应内容.*/

public class Demo {
    @Test
    public void test() throws Exception {
        //框架代码
        //1,加载配置文件
        //创建properties对象
        Properties pro = new Properties();
        //加载配置文件  获取class目录下的配置文件
        pro.load(new FileInputStream("C:\\Users\\奶爸\\Desktop\\pro.properties"));
        //获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //System.out.println(className);
       //System.out.println(methodName);
        //获取类对象
        Class cls = Class.forName(className);
        //创建对象
        Object obj = cls.newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);


    }
}
