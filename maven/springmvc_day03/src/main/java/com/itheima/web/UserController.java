package com.itheima.web;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
@Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public String findAll(){
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        return "success";
    }
//登录
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
       User user1 =  userService.login(user);
       //判断
        if (user1==null) {
            request.setAttribute("message","用户名或密码错误");
            return "forward:/login.jsp";
        }
        return "main";
    }
    @RequestMapping("/findAllUser")
    public String findAllUser(HttpServletRequest request){
        List<User> users = userService.findAll();
        request.setAttribute("users",users);
        return "user-list";
    }
    //增加
    @RequestMapping("/addUserUI")
    public String addUserUI(){
        return "user-add";
    }
    //保存
    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.save(user);
        //继续查询最新数据
        return "redirect:/findAllUser";
    }

}
