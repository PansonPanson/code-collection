package top.panson.seckill.redis.set;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Panson
 */
public class UvDemo {

    private Jedis jedis = new Jedis("127.0.0.1");


    /**
     * 添加一次用户的请求
     * @param userId
     */
    private void addUserAccess(long userId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(new Date());
        jedis.sadd("user_access::" + today, String.valueOf(userId));
    }


    private long getUv() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(new Date());
        return jedis.scard("user_access::" + today);
    }

    public static void main(String[] args) {
        UvDemo demo = new UvDemo();
        for(int i = 0; i < 100; i++) {
            long userId = i + 1;
            for (int j = 0; j < 10; j++) {
                demo.addUserAccess(userId);
            }
        }
        long uv = demo.getUv();
        System.out.println("当日uv 为： " + uv);
    }


}
