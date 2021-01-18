package Redis;

import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class RedisTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        String setName = jedis.get("myName");
        System.out.println(new String(setName.getBytes(), StandardCharsets.UTF_8));
    }
}
