package com.itheima.dao;

import com.itheima.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {

    /**
     * 根据用户名获取用户对象(唯一的用户对象)
     * @param username
     * @return
     */
    @Select("select * from sys_user where username = #{a} and status=1")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(
                    property = "roleList",column = "id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.RoleDao.findRoleListByUserId",fetchType = FetchType.LAZY)
            )
    })
    SysUser findByUsername(String username);
//查询所有
    @Select("select * from sys_user")
    List<SysUser> findAll();
    //保存数据
    @Insert("insert into sys_user values(user_seq.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(SysUser user);
    //判断用户是否唯一
    @Select("select * from sys_user where username = #{username}")
    SysUser findByUsernameIsUnique(String username);
    //查询用户的详情
    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(
                    property = "roleList",column = "id",javaType = List.class,
                    many = @Many(select = "com.itheima.dao.RoleDao.findRoleListByUserId",fetchType = FetchType.LAZY)
            )
    })
    SysUser findById(Integer userId);
    //删除用户原来的所有角色
    @Delete("delete from sys_user_role where userId = #{userId}")
    void delRolesFromUser(Integer userId);
    //给用户添加角色关系
    @Insert("insert into sys_user_role values(#{param1} ,#{param2})")
    void saveRolesToUser(Integer userId, Integer roleId);
}
