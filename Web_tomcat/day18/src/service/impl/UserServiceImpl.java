package service.impl;

import dao.UserDao;
import org.junit.Test;
import service.UserService;
import utils.BeanFactory;

public class UserServiceImpl implements UserService {
    private UserDao userDao = BeanFactory.newInstance(UserDao.class);
    @Override
    public int findAll(String name) {
        return userDao.count(name);
    }
    @Test
    public void testMethod(){
        int jack = findAll("jack");
        System.out.println(jack);
    }
}
