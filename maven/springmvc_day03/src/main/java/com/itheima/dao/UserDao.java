package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    User login(User user);

    void save(User user);
}
