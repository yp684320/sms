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
    @RequestMapping(value = "/findAll")
    public String findAll(){
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        return "success";//默认的请求转发
    }
    //登录
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        User userLogin = userService.login(user);
        if (userLogin==null) {
            //没有
            request.setAttribute("message","用户名和密码不匹配");
            return "forward:/login.jsp";
        }
        return "main";
    }
    //全查
    @RequestMapping("/findAllUser")
    public String findAllUser(HttpServletRequest request){
        List<User> list = userService.findAllUser();
        request.setAttribute("users",list);
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
//删除
    @RequestMapping("/deleteUserById")
    public String deleteUserById(int  id){
        userService.delete(id);
        //继续查询最新数据
        return "redirect:/findAllUser";
    }
}
