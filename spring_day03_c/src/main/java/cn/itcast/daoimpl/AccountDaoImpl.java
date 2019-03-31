package cn.itcast.daoimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void inMoney() {
        String sql = "update account set money = money+100 where name = 'jack'";
        try {
            queryRunner.update(JdbcUtils.get().get(),sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void toMoney() {
        String sql = "update account set money = money-100 where name = 'rose'";

        try {
            queryRunner.update(JdbcUtils.get().get(),sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
