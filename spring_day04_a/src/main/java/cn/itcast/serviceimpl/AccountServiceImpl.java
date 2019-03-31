package cn.itcast.serviceimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void tranFer() {
       //减钱
        accountDao.toMoney();

        accountDao.inMoney();
    }
}
