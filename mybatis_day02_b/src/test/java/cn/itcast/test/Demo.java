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
import java.util.List;

public class Demo {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        //创建SQLSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
         sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }
    @Test
   public void t1(){
       //获取SqlSession对象
       SqlSession sqlSession = sqlSessionFactory.openSession();
       //获取执行代理对象
       UserDao userDao = sqlSession.getMapper(UserDao.class);
       //执行操作
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        //释放资源
       sqlSession.close();
   }
    @Test
    public void t2(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //执行操作
        User user = new User();
        user.setAddress("北京");
        user.setSex("男");
        user.setUsername("石头");
        userDao.saveUser(user);
        //事务提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        System.out.println(user.getId());
    }
    @Test
    public void t3(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //执行操作
        User user = new User();
        user.setUsername("小石头");
        user.setSex("男");
       // user.setId(63);
        userDao.updateUser(user);
        //事务提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    @Test
    public void t4(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //执行操作
       userDao.deleteUser(58);
        //事务提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    @Test
    public void t5(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //执行操作
        User user = new User();
        user.setUsername("%王%");
        List<User> list = userDao.findLike(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
        //释放资源
        sqlSession.close();

    }
    @Test
    public void t6(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //执行操作
        User user = userDao.findById(48);
       sqlSession.commit();
        //释放资源
        sqlSession.close();
        System.out.println(user);
    }
    @Test
    public void t7(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUser(48);
        System.out.println(user);
        sqlSession.close();


    }

}
