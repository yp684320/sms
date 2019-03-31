package cn.itcast.serviceimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.daoimpl.AccountDaoImpl;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount(Account account) throws SQLException {
        accountDao.saveAccount(account);
    }

    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }

    public void updateAccount(int id) {
        accountDao.updateAccount(id);
    }

    public List<Account> findAll() {
        List<Account> list = accountDao.findAll();
        return list;
    }
}
