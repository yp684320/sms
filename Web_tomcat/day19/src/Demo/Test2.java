package Demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test2 {
    public static void main(String[] args) {
        //创建Redis的连接池
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(50);
        //初始化连接数
        config.setMinIdle(10);
        //最大空闲连接
        config.setMaxIdle(20);
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //需要连接时取连接池拿
        Jedis jedis = jedisPool.getResource();
        //操作数据
        String s = jedis.set("text", "Jack");
        String text = jedis.get("text");
        System.out.println(text);
        //用完换回去
        jedis.close();


    }
}
