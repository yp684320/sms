package cn.itcast.daoimpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class AccountDaoImpl  implements AccountDao{
    private QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }
    public void toMoney() {
        String sql = "update account set money = money-100 where name = '李飞'";
        try {
            qr.update(JdbcUtils.getTl().get(),sql);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

    }

    public void inMoney() {
        String sql = "update account set money = money + 100 where name = '李华'";
        try {
            qr.update(JdbcUtils.getTl().get(),sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
