package com.itheima.web;

import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.nio.Buffer;
import java.util.List;

@Controller
@RequestMapping("/user")
@Secured("ROLE_ADMIN")
public class UserController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //1,创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2, 准备数据
       List<SysUser> users = userService.findAll();
       //3, 数据添加到模型
        modelAndView.addObject("users",users);
        //4, 指定跳转页面
        modelAndView.setViewName("user-list");
        //返回modelAndView
        return modelAndView;

    }
    //保存
    @RequestMapping("/save")
    public String save(SysUser user){
        //保存数据
        userService.save(user);
        //请求全查
        return "redirect:/user/findAll";
    }
    //判断用户名是否唯一
    @ResponseBody//把数据以json格式返回页面
    @RequestMapping("/isUniqueUsername")
    public String isUniqueUsername(String username){
      //判断是否存在该用户
        boolean b = userService.isUniqueUsername(username);
        return String.valueOf(b);
    }
     //查询用户的详情功能
    @RequestMapping("/details")
    public ModelAndView details(Integer userId){
        //1,创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2, 查询数据
       SysUser user = userService.findById(userId);
        //3, 数据添加到模型
        modelAndView.addObject("user",user);
        //4, 指定跳转页面
        modelAndView.setViewName("user-show");
        //返回modelAndView
        return modelAndView;

    }
    //为用户添加角色回显
    @RequestMapping("/addRolesToUserUI")
    public ModelAndView addRolesToUserUI(Integer userId){
        //1,创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2, 查询数据
        //2.1 所有的角色
      List<Role> roles =   roleService.findAll();

      //2.2 该用户拥有的角色
        SysUser user = userService.findById(userId);
        //把该用户拥有的角色添加到字符串中
        StringBuffer sb = new StringBuffer();
        for (Role role : user.getRoleList()) {
            sb.append(",");
            sb.append(role.getId());
            sb.append(",");
        }
        //3, 数据添加到模型
       modelAndView.addObject("roles",roles);
        modelAndView.addObject("str",sb.toString());
        //把用户的id添加到模型中----页面
        modelAndView.addObject("userId",user.getId());
        //4, 指定跳转页面
        modelAndView.setViewName("user-role-add");
        //返回modelAndView
        return modelAndView;
    }
    //为用户添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Integer userId,Integer[] ids){
        //添加数据
        userService.addRoleToUser(userId,ids);
        //查询所有
    return "redirect:/role/findAll";
    }
}
