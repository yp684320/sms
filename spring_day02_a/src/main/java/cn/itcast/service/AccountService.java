package cn.itcast.service;

import cn.itcast.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    //全xml操作crud增删改查
    //插入一条数据
    public void saveAccount(Account account) throws SQLException;
    //删除数据
    public void deleteAccount(int id);
    //该数据
    public void updateAccount(int id);
    //查询所有
    public List<Account> findAll();
}
