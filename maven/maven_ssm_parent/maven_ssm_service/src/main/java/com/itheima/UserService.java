package com.itheima;

import com.itheima.domain.User;

public interface UserService {
    //通过id查询
    public User findById(int id);
}
