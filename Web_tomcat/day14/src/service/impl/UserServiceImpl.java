package service.impl;

import dao.UserDao;
import domain.PageBean;
import domain.User;
import service.UserService;
import utils.BeanFactory;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao = BeanFactory.newInstance(UserDao.class);

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public void delete(String id) {
        userDao.delete(id );
    }

    @Override
    public List<User> findByCondition(String sex, String address) {
        return userDao.findByCondition(sex, address);
    }

    @Override
    public List<User> findByPage(int pageNum, int pageSize) {
        return userDao.findPage(pageNum,pageSize);
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
        List<User> byPage = userDao.findPage(pageNum, pageSize);

        result.setData(byPage);
        //总条数
        int total = userDao.findTotal();

        result.setTotal(total);


        return result;
    }
}
