package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    //查询所有
    @Select("select * from sys_permission")
    List<Permission> findAll();
   //查询父权限
    @Select("select * from sys_permission where pid = 0")
    List<Permission> findParentPermissions();
    //保存数据
    @Insert("insert into sys_permission values(permission_seq.nextval,#{permissionName},#{url},#{pid})")
    void save(Permission permission);
    //通过roleId查询权限列表
    @Select("select s.* from sys_permission s,sys_role_permission sp where s.id = sp.permissionId and roleId = #{roleId}")
    public List<Permission> findPermissionListByroleId(Integer roleId);

}
