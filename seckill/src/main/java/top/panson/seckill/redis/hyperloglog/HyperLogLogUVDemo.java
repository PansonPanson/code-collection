package top.panson.seckill.redis.hyperloglog;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Panson
 */
public class HyperLogLogUVDemo {


    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 初始化 UV
     */
    public void initUVData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());

        for (int i = 0; i < 1358; i++) {
            jedis.pfadd("hyperloglog_uv_" + today, String.valueOf(i + 1));
        }
    }

    /**
     * 获取 UV
     * @return
     */
    public long getUV() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        return jedis.pfcount("hyperloglog_uv_" + today);
    }

    public static void main(String[] args) {
        HyperLogLogUVDemo demo = new HyperLogLogUVDemo();
        demo.initUVData();
        long uv = demo.getUV();
        System.out.println("今天的uv 值是：" + uv);

    }
}
