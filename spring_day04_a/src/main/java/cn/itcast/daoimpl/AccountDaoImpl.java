package cn.itcast.daoimpl;


import cn.itcast.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {
   private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void inMoney() {
        String sql = "update account set money = money + 100 where name = 'jack'";
        jdbcTemplate.update(sql);

    }

    public void toMoney() {
        String sql = "update account set money = money - 100 where name = 'rose'";
        jdbcTemplate.update(sql);
    }
}
