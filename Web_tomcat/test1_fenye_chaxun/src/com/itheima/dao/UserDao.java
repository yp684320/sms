package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void del(String id);

    List<User> findByCondition(String sex, String address);

    List<User> findByPage(int pageNum, int pageSize);

    int findTotal();
}
