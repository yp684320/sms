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
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
         sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }
    @Test//注解查询所有
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test//注解插入数据
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setSex("男");
        user.setUsername("张飞");
        user.setAddress("上海");
        userDao.saveUser(user);
        System.out.println(user.getId());
        sqlSession.close();

    }
    @Test//注解删除数据
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUser(50);
        sqlSession.close();
    }
    @Test//注解更新数据
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(49);
        user.setUsername("小张飞");
        userDao.updateUser(user);
        sqlSession.close();
    }
    @Test//注解通过id查询用户
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(48);
        System.out.println(user);
        sqlSession.close();
    }
    @Test//注解模糊查询
    public void test6(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("%王%");
        List<User> list = userDao.findLike(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
    @Test//注解查询数据总条数
    public void test7(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int count = userDao.findCount();
        System.out.println(count);
        sqlSession.close();
    }
    @Test//映射配置文件查询
    public void test8(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUser(48);
        System.out.println(user);
        sqlSession.close();
    }

}
