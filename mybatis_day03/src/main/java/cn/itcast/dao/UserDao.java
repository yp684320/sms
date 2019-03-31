package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    //查询所有的用户以及每个用户的所属账户信息
    //查询用户的所有账户信息
    public List<User> findUserByAccount();
}
