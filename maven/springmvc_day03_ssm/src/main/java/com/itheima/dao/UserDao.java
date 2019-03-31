package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    //全查
    public List<User> findAll();

    User login(User user);

    List<User> findAllUser();

    void save(User user);

    void delete(int id);
}
