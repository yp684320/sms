package Demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test4 {
    private static JedisPool pool;
    static{
        //创建Redis连接池
        JedisPoolConfig config = new JedisPoolConfig();
        //代表参数
        config.setMaxTotal(50);//最大连接数
        config.setMinIdle(10);//初始化连接数
        config.setMaxIdle(20);//闲置连接数

        pool = new JedisPool(config,"localhost",6379);
    }
    public static Jedis getConnection(){


        //获取连接
        Jedis jedis = pool.getResource();
        //还回去
        return jedis;
    }
}
