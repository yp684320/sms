package cn.itcast.core;

import cn.itcast.domain.Configuration;
import cn.itcast.domain.Mapper;
import cn.itcast.utils.Executor;

import java.util.List;
import java.util.Map;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration=configuration;
        // 工具类对象创建出来
        executor=new Executor(this.configuration);
    }

    // 操作数据库  //namespace.id
    // 所有连接数据的数据来源于configuration
    // 最终查询了resultSet结果集
    // resultSet结果集给User
    // 封装一个user望list中存一个


    public List findAll(String key) throws Exception {
        Map<String, Mapper> map = configuration.getMappers();
        Mapper mapper = map.get(key);
        String sql=mapper.getQuerySql(); //select * from user
        String resultType=mapper.getResultType(); //cn.itcst.domain.User

        // 给一个sql语句 给一个返回值类型 自动给你查询并将数据封装给User对象
        List list = executor.executeQuery(sql, resultType);
        return list;
    }
}
