package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {
    //查询所有
    List<Role> findAll();

    //保存
    void save(Role role);
   //通过id查询角色
    Role findById(Integer roleId);
    //保存数据
    void addPermissionToRole(Integer roleId, Integer[] ids);
}
