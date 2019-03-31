package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class SpringJunit {
    @Autowired
    private AccountService accountService;
    @Test//增
    public void test(){
        Account account = new Account();
        account.setName("木头");
        account.setMoney(5000);
        accountService.save(account);
    }
    @Test//删
    public void test1(){
        accountService.delete(9);
    }
    @Test//改
    public void test2(){
        accountService.update(3);
    }
    @Test//全查
    public void test3(){
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
    @Test//通过id查询
    public void test4(){
        Account account = accountService.findById(10);
        System.out.println(account);
    }
}
