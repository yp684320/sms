package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    //增
    public void saveAccount(Account account);
    //删
    public void deleteAccount(int id);
    //改
    public void updateAccount(int id);
    //全查
    public List<Account> findAll();
}
