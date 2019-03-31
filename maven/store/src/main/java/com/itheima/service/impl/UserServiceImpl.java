package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

public class UserServiceImpl implements UserService {
private UserDao userDao = BeanFactory.newInstance(UserDao.class);
    @Override
    public void regist(User user) {
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
         return userDao.findUser(username,password);

    }

}
