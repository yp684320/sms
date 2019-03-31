package cn.itcast.dao;

import cn.itcast.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    void saveAccount(Account account) throws SQLException;

    void deleteAccount(int id);

    void updateAccount(int id);

    List<Account> findAll();

}
