package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    //全查
    public List<User> findAll();
//登录
    User login(User user);
    //全查
    List<User> findAllUser();
    //增加
    void save(User user);
    //删除
    void delete(int id);
}
