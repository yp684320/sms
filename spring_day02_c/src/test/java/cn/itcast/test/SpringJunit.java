package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import cn.itcast.utils.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringJunit {
    @Autowired
    private AccountService accountService;
    @Test
    public void test(){
        Account account = new Account();
        account.setName("张开");
        account.setMoney(123);
        accountService.save(account);
    }
}
