package cn.itcast.serviceimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Transactional(isolation = Isolation.DEFAULT,timeout = -1,readOnly = false,propagation = Propagation.REQUIRED)
    public void tranFer() {
        //减钱
        accountDao.toMoney();
        //加钱
        accountDao.inMoney();
    }
}
