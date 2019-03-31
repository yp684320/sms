package cn.itcast.serviceimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void delete(int id) {
         accountDao.delete(id);
    }

    public void update(int id) {
        accountDao.update(id);
    }

    public List<Account> findAll() {
        List<Account> list = accountDao.findAll();
        return list;
    }

    public Account findById(int id) {
       Account account = accountDao.findById(id);
        return account;
    }
}
