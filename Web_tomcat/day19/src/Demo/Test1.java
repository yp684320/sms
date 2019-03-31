package Demo;

import redis.clients.jedis.Jedis;

public class Test1 {
    public static void main(String[] args) {
        //创建与Redis的连接
        Jedis jedis = new Jedis("localhost", 6379);
        //存取数据
        String xiaoming = jedis.set("text","小明");
        String text = jedis.get("text");
        System.out.println(text);
        //关闭连接
        jedis.close();

    }
}
