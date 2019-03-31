package cn.itcast.daoimpl;

import cn.itcast.core.SqlSession;
import cn.itcast.core.SqlSessionFactory;
import cn.itcast.core.SqlSessionFactoryBuilder;

import cn.itcast.domain.User;

import java.io.InputStream;
import java.util.List;

/*public class UserDaoImpl implements UserDao {
    public List<User> findAll() throws Exception {
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.bulid(is);
        //创建操作数据库对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //操作数据库
        List<User> list = sqlSession.findAll("user.getAll");
        return list;
    }
}*/
