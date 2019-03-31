package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.POJOUser;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        //创建SqlSessionFactoryBulider对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建 SqlSessionFactory对象
         sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }
    //查询所有
    @Test
    public void test1(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findUser();
        for (User user : list) {
            System.out.println(user);
        }
    }
    //条件查询
    @Test
    public void test2(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("小二王");
        user.setSex("女");
        List<User> list = userDao.findUserBy(user);
        for (User user1 : list) {
            System.out.println(user1);
        }


    }
    //包含查询-----数组
    @Test
    public void test3(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int[] arr={41,43,45};
        List<User> list = userDao.findUserArr(arr);
        for (User user : list) {
            System.out.println(user);
        }
    }
    //包含查询----集合
    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List list = new ArrayList();
        list.add(41);
        list.add(43);
        list.add(45);
        List<User> user = userDao.findUserList(list);
        for (User user1 : user) {
            System.out.println(user1);
        }

    }
    //包含查询----对象
    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List list = new ArrayList();
        list.add(41);
        list.add(43);
        list.add(45);
        POJOUser user = new POJOUser();
        user.setAbcd(list);
        List<User> pojoUser = userDao.findPOJOUser(user);
        for (User user1 : pojoUser) {
            System.out.println(user1);
        }

    }

}
