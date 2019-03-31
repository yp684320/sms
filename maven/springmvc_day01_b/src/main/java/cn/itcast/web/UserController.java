package cn.itcast.web;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

//页面数据的封装
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @RequestMapping(value = "/params1")
    public String params1(String username,Integer age){
        System.out.println(username);
        System.out.println(age);
        return "success";

    }
    @RequestMapping(value = "/params2")
    public String params2(User user){
        System.out.println(user);
        return "success";

    }
    @RequestMapping(value = "/params3")
    public String params3(User user){
        System.out.println(user);
        return "success";

    }
    @RequestMapping(value = "/params4")
    public String params4(User user){
        System.out.println(user);
        return "success";

    }
    @RequestMapping(value = "/params5")
    public String params5(Date date){
        System.out.println(date);
        return "success";

    }


}
