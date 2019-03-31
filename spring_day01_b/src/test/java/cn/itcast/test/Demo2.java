package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2 {
    public static void main(String[] args) {
        //创建容器管理对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //向容器获取对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.save();
    }
}
