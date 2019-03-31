package cn.itcast.serviceImpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;

public class AccountServiceImpl implements AccountService {
    //对象类型
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void save() {
        accountDao.save();
    }
}
