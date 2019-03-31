package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    @Test
public void t1() throws IOException {
    //创建SQLSessionFactoryBudiler对象
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    //创建SQLSessionFactory对象
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    //获取SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //获取代理对象
    UserDao userDao = sqlSession.getMapper(UserDao.class);
    //执行方法
    List<User> list = userDao.findAll();
    for (User user : list) {
        System.out.println(user);
    }
}
}
