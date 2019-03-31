package com.itheima.controller;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id){
        User user = userService.findById(id);
        System.out.println(user);
        return user;
    }
    @RequestMapping("list")
    public String queryUserAll(Model model){
        List<User> userList = userService.queryAll();
        model.addAttribute("userlist",userList);
        return "user";

    }

}
