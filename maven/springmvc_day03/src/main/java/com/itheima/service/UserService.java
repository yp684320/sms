package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    User login(User user);

    void save(User user);
}
