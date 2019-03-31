package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountDao {
    void save(Account account);

    void delete(int id);

    void update(int id);

    List<Account> findAll();

    Account findById(int id);
}
