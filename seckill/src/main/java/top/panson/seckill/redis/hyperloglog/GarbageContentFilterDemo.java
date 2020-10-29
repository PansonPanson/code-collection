package top.panson.seckill.redis.hyperloglog;

import redis.clients.jedis.Jedis;

/**
 * @Author: Panson
 */
public class GarbageContentFilterDemo {

    private Jedis jedis = new Jedis("127.0.0.1");


    public Boolean isGarbageContent(String content) {
        return jedis.pfadd("hyperloglog_content", content) == 0;
    }

    public static void main(String[] args) {
        GarbageContentFilterDemo demo = new GarbageContentFilterDemo();

        String content = "正常的内容";
        System.out.println("是否为垃圾内容；" + (demo.isGarbageContent(content) ? "是" : "否"));
        content = "垃圾内容";
        System.out.println("是否为垃圾内容；" + (demo.isGarbageContent(content) ? "是" : "否"));
        content = "垃圾内容";
        System.out.println("是否为垃圾内容；" + (demo.isGarbageContent(content) ? "是" : "否"));
    }


}
