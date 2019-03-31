package cn.itcast.dao;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;

import java.util.List;

public interface AccountDao {
    //查询所有的账户以及每个账户的所属用户信息
    public List<Account> findAccountByUser();
}
