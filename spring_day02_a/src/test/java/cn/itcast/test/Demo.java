package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Demo {
    private AccountService accountService;
    @Before
    public void init(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
         accountService = (AccountService) applicationContext.getBean("accountService");
    }
    @Test//插入数据
    public void test() throws SQLException {

        Account account = new Account();
        account.setName("Jack");
        account.setMoney(2000);
        accountService.saveAccount(account);

    }
    @Test//删除数据
    public void test1(){
        accountService.deleteAccount(5);
    }
    @Test//该数据
    public void test2(){
        accountService.updateAccount(2);
    }
    @Test//查询所有
    public void Test3(){
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }

}
