package cn.itcast.core;

import java.util.List;

//操作数据库的接口 创建它的不同的实现类  可以操作不同的数据库
public interface SqlSession {
    public <E> List<E> findAll(String key) throws Exception;
}
