package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountDao {
    //增加数据
    public void saveAccount(Account account);
    //删
    void deleteAccount(int id);
    //改
    void updateAccount(int id);

    List<Account> findAll();

}
