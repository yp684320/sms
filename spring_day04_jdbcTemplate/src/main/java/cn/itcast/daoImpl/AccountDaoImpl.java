package cn.itcast.daoImpl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Account account) {
        String sql = "insert into account values(null,?,?)";
        jdbcTemplate.update(sql,account.getName(),account.getMoney());
    }

    public void delete(int id) {
       String sql = "delete from account where id = ?";
       jdbcTemplate.update(sql,id);
    }

    public void update(int id) {
        String sql = "update account set name = '小明' where id = ?";
        jdbcTemplate.update(sql,id);
    }

    public List<Account> findAll() {
        String sql = "select * from Account";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        return list;
    }

   /* public Account findById(int id) {
        String sql = "select * from account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class),id);
        return account;
    }*/
    public Account findById(int id) {
        String sql = "select * from account where id = ?";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class),id);
        Account account = list.get(0);
        return account;
    }
}
