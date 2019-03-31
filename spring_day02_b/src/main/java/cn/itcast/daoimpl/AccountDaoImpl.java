package cn.itcast.daoimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository(value = "accountDao")
public class AccountDaoImpl implements AccountDao {
//增加数据
    @Autowired
    private QueryRunner qr;
    //增
    public void saveAccount(Account account) {
        String sql = "insert into account values(null,?,?)";
        try {
            qr.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
   //删
    public void deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
   //改
    public void updateAccount(int id) {
        String sql = "update account set name = '陈怡' where id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //全查
    public List<Account> findAll() {
       String sql = "select * from account";
        try {
            return qr.query(sql,new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
