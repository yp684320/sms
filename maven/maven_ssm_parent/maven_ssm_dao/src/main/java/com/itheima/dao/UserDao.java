package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
    //通过id查询
    public User findById(int id);
}
