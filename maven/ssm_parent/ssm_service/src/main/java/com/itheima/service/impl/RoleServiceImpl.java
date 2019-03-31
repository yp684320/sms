package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        //查询所有
        return roleDao.findAll();
    }

    //保存
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] ids) {
        //清空原有数据
        roleDao.clearPermissionsFromRole(roleId);
        //判断ids是否为空
        //维护新的权限关系
        if (ids!=null) {
            for (Integer permissionId : ids) {
                roleDao.addPermissionToRole(permissionId ,roleId);
            }
        }
    }

}
