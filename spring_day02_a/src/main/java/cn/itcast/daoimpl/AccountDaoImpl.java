package cn.itcast.daoimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao{
    private QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }
    //插入数据
    public void saveAccount(Account account) throws SQLException {
        String sql = "insert into account values(null,?,?)";
        int update = qr.update(sql,account.getName(),account.getMoney());
    }
    //删除数据
    public void deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //修改数据
    public void updateAccount(int id) {
        String sql = "update account set name = 'rose' where id = ?";
        try {
            qr.update(sql,id);
        } catch (SQLException e) {


        }
    }

    public List<Account> findAll() {
        String sql = "select * from account";
        try {
           return qr.query(sql,new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
