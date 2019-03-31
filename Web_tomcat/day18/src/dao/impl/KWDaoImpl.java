package dao.impl;

import dao.KWDao;
import domain.KW;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class KWDaoImpl implements KWDao {
    @Override
    public List<KW> findAll(String value) {
        //创建执行对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //编写sql语句
        String sql = "select * from kw where name like ?";
        //执行语句
        try {
            return  qr.query(sql,new BeanListHandler<>(KW.class),"%"+value+"%");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    //测试与数据库是否成功连接
    @Test
    public void rnu(){
        List<KW> kws = findAll("小米");
        for (KW kw : kws) {
            System.out.println(kw.getName());
        }
    }
}
