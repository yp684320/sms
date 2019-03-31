package cn.itcast.daoimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }
//增
    public void save(Account account) {
        String sql = "insert into account values(null,?,?)";
        try {
            qr.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//删
    public void delete(int id) {
        String sql = "delete from account where id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//改
    public void update(int id) {
        String sql = "update account set name = '李飞' where id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        String sql = "select * from account";
        try {
          return  qr.query(sql,new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Account findById(int id) {
        String sql = "select * from account where id = ?";
        try {
           return qr.query(sql,new BeanHandler<Account>(Account.class),id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
