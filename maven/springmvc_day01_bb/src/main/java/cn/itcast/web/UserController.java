package cn.itcast.web;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/params1")
    public String params1(String username ,Integer age){
        System.out.println(username);
        System.out.println(age);
        return "success";

    }
    @RequestMapping(value = "/params2")
    public String params2(User user){
        System.out.println(user);
        return "success";
    }
}
