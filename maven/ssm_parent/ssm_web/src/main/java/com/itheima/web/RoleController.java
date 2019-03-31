package com.itheima.web;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
@Secured("ROLE_ADMIN")
public class RoleController {
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleService;
    //查询所有
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //1, 创建modelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2, 准备数据
       List<Role> roles = roleService.findAll();
       //3, 数据添加等到模型
        modelAndView.addObject("roles",roles);
        //4, 指定跳转页面
        modelAndView.setViewName("role-list");
        //5, 返回modelAndView对象
        return modelAndView;
    }
    //保存
    @RequestMapping("/save")
    public String save(Role role){
        //1 准备数据
        roleService.save(role);
        //2 指定跳转页面
        return "redirect:/role/findAll";

    }
    //给角色添加权限数据回显
    @RequestMapping("/addPermissionToRoleUI")
    public ModelAndView addPermissionToRoleUI(Integer roleId){
        //1, 创建modelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2, 查询所有权限
        List<Permission> permissions = permissionService.findAll();
        //该用户拥有的权限
       Role role = roleService.findById(roleId);
        StringBuffer str = new StringBuffer();
        //遍历权限
        for (Permission permission : role.getPermissionList()) {
            str.append(",");
            str.append(permission.getId());
            str.append(",");
        }
        //3,把数据添加到modelAndView模型中
        modelAndView.addObject("permissions",permissions);
        modelAndView.addObject("str",str);
        modelAndView.addObject("roleId",roleId);
        //4 指定跳转页面
        modelAndView.setViewName("role-permission-add");
        //5, 返回模型
        return modelAndView;

    }
    //保存数据
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(Integer roleId,Integer[] ids){
      //保存数据
        roleService.addPermissionToRole(roleId,ids);
        //请求全查
        return "redirect:/role/findAll";

    }
}
