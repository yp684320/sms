package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    //增加数据
    public void save(Account account);
    //删
    public void delete(int id);
    //改
    public void update(int id);
    //全查
    public List<Account> findAll();
    //条件查找  id
    Account findById(int id);
}
