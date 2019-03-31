package cn.itcast.test;

import cn.itcast.serviceimpl.UserServiceImpl;
import cn.itcast.srevice.UserService;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class Demo2 {
    @Test
    public void test(){

      final   UserServiceImpl userService = new UserServiceImpl();
      //使用jdk提供的基于接口的动态代理对save 方法进行增强
        //参数1  和目标对象一样的类加载器
        //参数2  和目标对象一样的接口
        //参数3  增强业务类
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                new Class[]{UserService.class},
                new InvocationHandler() {
                    //参数1  代理对象的应用
                    //参数2  要增强的方法
                    //参数3  增强的方法运行中需要的参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //判断给哪个方法进行增强
                        //增强业务
                        //参数1   本身应该调用这个方法的对象
                        //参数2    方法调用过程中需要的参数

                        try {
                            if ("save".equals(method.getName())) {
                                System.out.println("之前增强");
                                Object value = method.invoke(userService, args);//让原方法执行
                                System.out.println(value);
                                System.out.println("之后增强");
                            }
                        } catch (Exception e) {
                            System.out.println("异常增强");

                        } finally {
                            System.out.println("最终增强");
                        }
                          return "xxx";
                    }
                });
        //调用代理对象的方法
        String s = userServiceProxy.save("牛油果");//只要代理对象调用任何方法   invoke方法都会执行  执行的内容是对当前方法(save)的增强
        System.out.println(s);

    }
}
