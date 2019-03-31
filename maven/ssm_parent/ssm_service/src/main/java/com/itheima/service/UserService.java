package com.itheima.service;

import com.itheima.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserService extends UserDetailsService {
    //查询所有
    List<SysUser> findAll();


    //保存
    void save(SysUser user);
    //判断用户是否唯一
    boolean isUniqueUsername(String username);
    //查询用户的详情
    SysUser findById(Integer userId);
    //为用户添加角色
    void addRoleToUser(Integer userId, Integer[] ids);
}
