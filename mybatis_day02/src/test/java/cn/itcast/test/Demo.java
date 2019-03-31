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

/*保存用户
更新用户
删除用户
查询全部用户
根据id查询用户
模糊查询用户
统计用户数量
*/
public class Demo {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        //创建SqlSessionFactoryBulider对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }
    //增加数据
    @Test
    public void test1() throws IOException {
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("小李");
        user.setSex("男");
        user.setAddress("北京");
        //操作
        userDao.saveUser(user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        System.out.println(user);
    }
    //增加数据
    @Test
    public void test2() throws IOException {
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取dao的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //操作
        User user = new User();
        user.setUsername("老李");
        user.setId(53);
        userDao.updateUser(user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        System.out.println(user);
    }
    //删除
    @Test
    public void test3() throws IOException {
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //操作
        userDao.deleteUser(57);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
    //查询所有
    @Test
    public void test4() throws IOException {
        //  获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //  操作
        List<User> list = userDao.findAll();
        // 释放资源
        sqlSession.close();
        for (User user : list) {
            System.out.println(user);
        }
    }
    //根据id查询
    @Test
    public void test5() throws IOException {
        //  获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //  操作
        User user = userDao.findById(48);
        // 释放资源
        sqlSession.close();
        System.out.println(user);
    }
    //模糊查询
    @Test
    public void test6() throws IOException {
        //  获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user1 = new User();
        user1.setUsername("%王%");
        //  操作
        List<User> list = userDao.findLike(user1);
        for (User user : list) {
            System.out.println(user);
        }
        // 释放资源
        sqlSession.close();

    }
    //统计用户数量
    @Test
    public void test7() throws IOException {
        //  获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
       //操作
        int count = userDao.findCount();
        System.out.println(count);
        // 释放资源
        sqlSession.close();

    }
    //映射配置文件
    @Test
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

    }
}
