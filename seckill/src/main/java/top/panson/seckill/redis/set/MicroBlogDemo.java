package top.panson.seckill.redis.set;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Author: Panson
 */
public class MicroBlogDemo {

    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 关注别人
     * @param userId
     * @param followUserId
     */
    public void follow(long userId, long followUserId) {
        jedis.sadd("users::" + followUserId + "::followers", String.valueOf(userId));
        jedis.sadd("users::" + userId + "::follow_users", String.valueOf(followUserId));
    }

    /**
     * 取消关注别人
     * @param userId
     * @param followUserId
     */
    public void unFollow(long userId, long followUserId) {
        jedis.srem("users::" + followUserId + "::followers", String.valueOf(userId));
        jedis.srem("users::" + userId + "::follow_users", String.valueOf(followUserId));
    }

    /**
     * 查看关注自己的
     * @param userId
     * @return
     */
    public Set<String> getFollowers(long userId) {
        return jedis.smembers("user::" + userId + "::followers");
    }

}
