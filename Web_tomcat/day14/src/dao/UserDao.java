package dao;

import domain.PageBean;
import domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void delete(String id);

    List<User> findByCondition(String sex,String address);


    List<User> findPage(int pageNum, int pageSize);

    int findTotal();




}
