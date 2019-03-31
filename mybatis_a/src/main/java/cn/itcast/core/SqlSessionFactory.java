package cn.itcast.core;

import cn.itcast.domain.Configuration;
//// 工厂对象
//// 作用：创建sqlsession接口的实现类操作数据库
public class SqlSessionFactory {
    private Configuration configuration;
    public SqlSessionFactory(Configuration configuration) {
        this.configuration=configuration;
    }
    //创建SqlSession的实现类  传递;configuration
    public SqlSession openSession(){
        SqlSession sqlSession=new DefaultSqlSession(this.configuration);
        return sqlSession;
    }
}
