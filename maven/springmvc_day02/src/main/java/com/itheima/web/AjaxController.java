package com.itheima.web;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
    @RequestMapping("/ajax")
    public @ResponseBody User ajax(@RequestBody User user){
        System.out.println(user);
        User user1 = new User();
        user1.setId(12);
        user1.setUsername("李飞");
        user1.setPassword("123");

        return user1;
    }

}
