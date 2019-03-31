package cn.itcast.test;

import cn.itcast.serviceimpl.UserServiceImpl;
import cn.itcast.srevice.UserService;
import org.junit.Test;

public class Demo1 {
@Test
    public void test (){
        UserService userService = new UserServiceImpl();
        String s = userService.save("牛油果");
        System.out.println(s);
    }


}
