package top.panson.seckill.redis.list;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Author: Panson
 */
public class SendMailDemo {

    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 将发送邮件任务放入队列
     * @param sendMailTask
     */
    public void enqueueSendMailTask(String sendMailTask) {
        jedis.lpush("send_mail_task_queue", sendMailTask);
    }

    /**
     * 阻塞式获取发送邮件任务
     *
     * @return
     */
    public List<String> taskSendMailTask() {
        return jedis.brpop(5, "send_mail_task_queue");
    }





}
