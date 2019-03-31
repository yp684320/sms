package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
    //通过id查询用户信息
    User findById(Integer id);
}
