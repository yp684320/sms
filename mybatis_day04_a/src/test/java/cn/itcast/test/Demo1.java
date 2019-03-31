package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo1 {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
         sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }
    @Test//根据账户查询用户信息
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> list = accountDao.findAccount();
        for (Account account : list) {
            System.out.println(account.getUid());
            //System.out.println(account.getUser());
           // System.out.println(account.getUser());//测试一级缓存
        }
        sqlSession.close();
    }
    @Test//根据用户查询账户信息
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findAllUser();
        for (User user : list) {
           System.out.println(user.getId());
            //System.out.println(user.getAccounts());
            //System.out.println(user);
        }
        sqlSession.close();
    }


}





