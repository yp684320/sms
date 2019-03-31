package cn.itcast.daoimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository(value = "accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner qr;
    public void save(Account account) {
        String sql = "insert into account values(null,?,?)";
        try {
            qr.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
