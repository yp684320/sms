package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
    void save(User user);

    User findUser(String username, String password);
}
