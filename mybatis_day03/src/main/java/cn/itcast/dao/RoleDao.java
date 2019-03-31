package cn.itcast.dao;

import cn.itcast.domain.Role;

import java.util.List;

public interface RoleDao {
    //角色到用户的一对多查询角色到用户的一对多查询
    //查询角色的所有用户信息
    public List<Role> findRole();
}
