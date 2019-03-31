package com.itheima.web;

import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
@Secured("ROLE_ADMIN")
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //1, 创建modelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2 准备数据
       List<Permission> permissions = permissionService.findAll();
       //3, 数据添加到模型
        modelAndView.addObject("permissions",permissions);
        //4, 指定跳转路径
        modelAndView.setViewName("permission-list");
        //5, 返回modelAndView对象
        return modelAndView;

    }
    //数据回显
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        //1. 创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(1);
        //2. 准备数据
        List<Permission> permissions = permissionService.findParentPermissions();
        System.out.println(2);
        for (Permission permission : permissions) {
            System.out.println(permission);
        }
        //3. 添加模型数据
        modelAndView.addObject("permissions",permissions);
        //4. 指定跳转页面
        modelAndView.setViewName("permission-add");
        //5. 返回ModelAndView对象
        return  modelAndView;
    }
    //保存
    @RequestMapping("/save")
    public String save(Permission permission){
        //准备数据
        permissionService.save(permission);
        //指定跳转页面
        return "redirect:/permission/findAll";
    }
}
