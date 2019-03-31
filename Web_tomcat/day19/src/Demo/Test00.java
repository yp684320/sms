package Demo;

import redis.clients.jedis.Jedis;

public class Test00 {
    public static void main(String[] args) {
        //获取连接
        Jedis jedis = RedisUtil.getConnection();
        //操作数据
        String s = jedis.set("name", "Jack");
        String name = jedis.get("name");
        System.out.println(name);
    }
}
