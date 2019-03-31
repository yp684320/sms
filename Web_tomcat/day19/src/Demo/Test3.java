package Demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test3 {
    public static Jedis getConnection() {
        //创建redis连接池
        JedisPoolConfig config = new JedisPoolConfig();
        //代表的参数
        config.setMaxTotal(50);//最大连接数
        config.setMaxIdle(10);//闲置连接收
        config.setMinIdle(20);//初始化连接数
        JedisPool pool = new JedisPool(config,"localhost",6379);
        //获取连接
        Jedis jedis = pool.getResource();
        //还回连接
        return jedis;

    }
}
