package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class RedisUtil {
    private static JedisPool pool;
    static{
        //创建与redis的连接池
        //代表是池的参数
        JedisPoolConfig config = new JedisPoolConfig();
        //读取配置文件

        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        String host = bundle.getString("host");
        int port =Integer.parseInt(bundle.getString("port"));
        int maxTotal =Integer.parseInt(bundle.getString("maxTotal"));
        int maxIdle =Integer.parseInt(bundle.getString("maxIdle"));
        int minIdle =Integer.parseInt(bundle.getString("minIdle"));




        config.setMaxTotal(maxTotal);//最大连接数
        config.setMinIdle(minIdle);//初始化连接数
        config.setMaxIdle(maxIdle);//最大空闲连接


        pool = new JedisPool(config, host, port);

    }
    public static Jedis getConnection(){
        //需要连接的时候 找池子去借

        Jedis jedis = pool.getResource();

        return jedis;
    }
}
