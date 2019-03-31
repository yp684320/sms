package service;

import domain.PageBean;
import domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void delete(String id);

    List<User> findByCondition(String sex,String address);

    List<User> findByPage(int pageNum,int pageSize);

    int findTotal();

    PageBean<User> findByPage1(int pageNum, int pageSize);
}
