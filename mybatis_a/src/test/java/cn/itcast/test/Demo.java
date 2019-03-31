package cn.itcast.test;


import cn.itcast.core.SqlSession;
import cn.itcast.core.SqlSessionFactory;
import cn.itcast.core.SqlSessionFactoryBuilder;
import cn.itcast.domain.User;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Demo {
    @Test
    public void t1() throws Exception {
       /* UserDaoImpl userDao = new UserDaoImpl();
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }*/
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.bulid(is);
        //创建操作数据库对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //操作数据库
        List<User> list = sqlSession.findAll("user.getAll");
        for (User user : list) {
            System.out.println(user);
        }

    }
}
