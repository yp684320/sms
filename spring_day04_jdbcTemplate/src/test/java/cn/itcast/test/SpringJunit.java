package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class SpringJunit {
    @Autowired
    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    @Test//增
    public void test1(){
        Account account = new Account();
        account.setName("小花");
        account.setMoney(234);
        accountService.save(account);
    }
    @Test//删
    public void test2(){
        accountService.delete(1);
    }
    @Test//改
    public void test3(){
        accountService.update(10);
    }
    @Test//全查
    public void test4(){
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
    @Test//通过id查
    public void test5(){
        Account account = accountService.findById(4);
        System.out.println(account);
    }

}
