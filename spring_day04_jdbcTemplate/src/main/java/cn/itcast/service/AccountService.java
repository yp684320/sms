package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    //增
    void save(Account account);
    //删
    void delete(int id);
    //该
    void update(int id);
    //全查
    List<Account> findAll();
    //条件查询
    Account findById(int id);
}
