package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.service.UserService;
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
    private UserService userService;
    @Test
    public void test(){
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }

    }
}
