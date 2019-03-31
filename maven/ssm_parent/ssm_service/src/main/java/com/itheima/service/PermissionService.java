package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {
    //查询所有
    List<Permission> findAll();
    //查询父权限
    List<Permission> findParentPermissions( );
    //保存数据
    void save(Permission permission);

}
