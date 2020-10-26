package top.panson.seckill.redis.list;

import redis.clients.jedis.Jedis;

/**
 * 秒杀案例
 * @Author: Panson
 */
public class SeckillDemo {

    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 秒杀抢购请求队列
     * @param seckillRequest
     */
    public void enqueueSeckillRequest(String seckillRequest) {
        jedis.lpush("sec_kill_request_queue", seckillRequest);
    }

    /**
     * 秒杀抢购请求出队
     * @return
     */
    public String dequeueSecKillRequest() {
        return jedis.rpop("sec_kill_request_queue");
    }

    public static void main(String[] args) throws Exception {
        SeckillDemo seckillDemo = new SeckillDemo();
        for (int i = 0; i < 10; i++) {
            seckillDemo.enqueueSeckillRequest("第" + (i + 1) + "个秒杀请求");
        }
        while(true) {
            String secKillRequest = seckillDemo.dequeueSecKillRequest();
            if(secKillRequest == null) {
                System.out.println("队列已经为空");
                break;
            }
            System.out.println(secKillRequest);
        }
    }

}
