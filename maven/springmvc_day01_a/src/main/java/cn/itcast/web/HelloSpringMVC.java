package cn.itcast.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class HelloSpringMVC {
    @RequestMapping(path = "/hello")
    public String hello(){
        System.out.println("访问到我了");
        return "Hello";

    }

}
