package com.itheima.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(value = {"username","password"})
public class SessionController {
    @RequestMapping(value = "/save")
    public String test1(Model model){
        Model model1 = model.addAttribute("username", "zxc");
        System.out.println(model1);
        return "success";
    }
    @RequestMapping("/find")
    public String test2(ModelMap map){
        //获取session域中的数据
        Object username = map.get("username");
        System.out.println(username);
        return "success";

    }
    @RequestMapping("/delete")
    public String test3(SessionStatus status){
        //清空session域中的数据
        status.setComplete();
        return "success";

    }
}
