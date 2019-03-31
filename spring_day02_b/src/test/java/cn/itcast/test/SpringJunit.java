package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//spring单元测试
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class SpringJunit {
    @Autowired
    private AccountService accountService;
    @Test//增
    public void test(){
        Account account = new Account();
        account.setName("李华");
        account.setMoney(3500);
        accountService.saveAccount(account);
    }
    @Test//删
    public void test1(){
        accountService.deleteAccount(8);
    }
    @Test//改
    public void test2(){
        accountService.updateAccount(4);
    }
    @Test
    public void test3(){
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
