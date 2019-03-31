package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void del(String id);

    List<User> findByCondition(String sex, String address);

    List<User> findByPage(int pageNum, int pageSize);

    int findTotal();

    PageBean<User> findByPage1(int pageNum, int pageSize);
}
