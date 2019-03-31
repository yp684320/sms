package cn.itcast.daoimpl;

import cn.itcast.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void toMoney() {
        String sql = "update account set money = money - 100 where name = 'Jack'";
        jdbcTemplate.update(sql);
    }

    public void inMoney() {
        String sql = "update account set money = money + 100 where name = 'rose'";
        jdbcTemplate.update(sql);
    }
}
