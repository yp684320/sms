package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        //System.out.println("我是测试");
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public void save(User user) {

    }
}
