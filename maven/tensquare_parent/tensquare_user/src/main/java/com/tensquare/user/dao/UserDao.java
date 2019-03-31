package com.tensquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.user.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    //根据电话号码查询用户
    public User findByMobile(String mobile);

    //修改粉丝数
    @Query(value = "UPDATE tb_user SET fanscount=fanscount+? WHERE id = ?", nativeQuery = true)
    @Modifying
    void fanscount(Integer x, String userid);

    //修改关注数
    @Query(value = "UPDATE tb_user SET followcount=followcount+? WHERE id = ?", nativeQuery = true)
    @Modifying
    void followcount(Integer x, String userid);
}
