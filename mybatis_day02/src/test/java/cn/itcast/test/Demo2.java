package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo2 {
    private SqlSessionFactory sqlSessionFactory;

    @Before //在测试方法之前会执行的方法
    public void init() throws IOException {
        // 1 创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2 创建sqlSessionFactory
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }

    @Test  //根据id查询 --映射配置
    public void t5() throws IOException {

        // 3 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4 获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 5 操作
        User user = userDao.findUser(48);
        // 释放资源
        sqlSession.close();
        System.out.println(user);
    }
    /*@Test
    public void test8() throws IOException {
        //  获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //操作
        User user = userDao.findUser(43);
        System.out.println(user);
        // 释放资源
        sqlSession.close();

    }*/
}
