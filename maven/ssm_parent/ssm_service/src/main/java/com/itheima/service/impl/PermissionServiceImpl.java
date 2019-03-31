package com.itheima.service.impl;

import com.itheima.dao.PermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        //查询所有
        return permissionDao.findAll();
    }

    @Override
    public List<Permission> findParentPermissions() {
        return permissionDao.findParentPermissions();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
