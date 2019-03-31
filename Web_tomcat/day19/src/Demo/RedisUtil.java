package Demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class RedisUtil {
    private static JedisPool pool;
    static{
        //创建Jedis连接池
        JedisPoolConfig config = new JedisPoolConfig();
        //读取配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        String host = bundle.getString("host");
       /* String port = bundle.getString("port");
        //转化为int类型
        int port1 = Integer.parseInt(port);*/
        int port =Integer.parseInt( bundle.getString("port"));
        int maxTotal =Integer.parseInt( bundle.getString("maxTotal"));
        int minIdle =Integer.parseInt( bundle.getString("minIdle"));
        int maxIdle =Integer.parseInt( bundle.getString("maxIdle"));

        //代表canshu
        config.setMaxTotal(maxTotal);//最大连接数
        config.setMaxIdle(maxIdle);//闲置连接数
        config.setMinIdle(minIdle);//初始化连接数

        pool = new JedisPool(config,host,port);
    }
    public static Jedis getConnection(){

        //需要连接时  找连接池
        Jedis jedis = pool.getResource();
        return jedis;

    }
}
