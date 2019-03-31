package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.Role;
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

public class Demo {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        //创建SqlSessionFactoryBulider对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
         sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }
    //角色到用户的一对多查询角色到用户的一对多查询
    //查询角色的所有用户信息
    @Test
    public void test() {

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        List<Role> list = roleDao.findRole();
        for (Role role : list) {
            System.out.println(role);
        }
        sqlSession.close();
    }
    //查询所有的账户以及每个账户的所属用户信息
    @Test
    public void test1() {

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
       List<Account> accounts = accountDao.findAccountByUser();
        for (Account account : accounts) {
            System.out.println(account);
        }

        sqlSession.close();

    }
    @Test
    //查询所有的用户以及每个用户的所属账户信息
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findUserByAccount();
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
