package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDao {
    //查询所有
    @Select("select * from sys_role")
    List<Role> findAll();

    //保存
    @Insert("insert into sys_role values(role_seq.nextval,#{roleName},#{roleDesc})")
    void save(Role role);
    //通过Id查询获取角色列表
    @Select("select s.* from sys_role s,sys_user_role sr where s.id = sr.roleId and userId = #{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionListByroleId",fetchType = FetchType.LAZY)
            )
    })
    public List<Role> findRoleListByUserId(Integer userId);

    /**
     * 通过id查询角色
     * @param roleId
     * @return
     */
    @Select("select * from sys_role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissionList",column = "id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.PermissionDao.findPermissionListByroleId",fetchType = FetchType.LAZY)
            )
    })

    Role findById(Integer roleId);
    /**
     *清空原有权限
     */
    @Delete("delete from sys_role_permission where roleId = #{roleId}")
    void clearPermissionsFromRole(Integer roleId);

    /**
     * 维护新的权限
     * @param permissionId
     */
    @Insert("insert into sys_role_permission values(#{param1},#{param2})")
    void addPermissionToRole(Integer permissionId,Integer roleId);
}
