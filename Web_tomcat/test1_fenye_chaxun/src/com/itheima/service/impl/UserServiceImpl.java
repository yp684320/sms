package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao= BeanFactory.newInstance(UserDao.class);

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void del(String id) {
        userDao.del(id);
    }

    @Override
    public List<User> findByCondition(String sex, String address) {

        return userDao.findByCondition(sex,address);
    }

    @Override
    public List<User> findByPage(int pageNum, int pageSize) {
        return userDao.findByPage(pageNum,pageSize);
    }

    @Override
    public int findTotal() {
        return userDao.findTotal();
    }

    @Override
    public PageBean<User> findByPage1(int pageNum, int pageSize) {
        PageBean<User> result=new PageBean<>();

        //当前的页码
        result.setPageNumber(pageNum);
        result.setPageSize(pageSize);

        //当前页的数据
        List<User> byPage = userDao.findByPage(pageNum, pageSize);

        result.setData(byPage);
        //总条数
        int total = userDao.findTotal();

        result.setTotal(total);


        return result;
    }
}
