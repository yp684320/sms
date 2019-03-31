package Demo;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        //获取连接
        Jedis jedis = Test3.getConnection();
        //操作
        String s = jedis.set("username", "rose");
        String username = jedis.get("username");
        System.out.println(username);
    }
}
