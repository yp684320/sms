package service.impl;

import dao.UserDao;
import domain.User;
import service.UserService;
import utils.BeanFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = BeanFactory.newInstance(UserDao.class);
    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }
}
