package cn.itcast.serviceimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }

    public void updateAccount(int id) {
        accountDao.updateAccount(id);
    }

    public List<Account> findAll() {
       List<Account> list =  accountDao.findAll();
        return list;
    }
}
