package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User findById(Long id){
        return userDao.findById(id).get();
    }

    public List<User> queryAll() {
       return userDao.findAll();
    }

}
