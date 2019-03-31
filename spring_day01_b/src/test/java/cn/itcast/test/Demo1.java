package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {
        //创建容器管理对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //向容器获取对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService==accountService1);//测试scope属性  单例与多例
        //关闭容器
        applicationContext.close();
    }
}
