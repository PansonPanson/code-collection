package top.panson.seckill.redis.set;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Author: Panson
 */
public class MomentsDemo {

    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 对朋友圈进行点赞
     * @param userId
     * @param momentId
     */
    public void likeMoment(long userId, long momentId) {
        jedis.sadd("moment_like_users::" + momentId, String.valueOf(userId));
    }


    /**
     * 取消点赞
     * @param userId
     * @param momentId
     */
    public void dislikeMoment(long userId, long momentId) {
        jedis.srem("moment_like_users::" + momentId, String.valueOf(userId));
    }

    /**
     * 查看某个用户是否点赞过某条朋友圈
     * @param useId
     * @param momentId
     * @return
     */
    public boolean hasDislikedMoment(long useId, long momentId) {
        return jedis.sismember("moment_like_users::" + momentId, String.valueOf(useId));
    }

    /**
     * 获取你的一条朋友圈有哪些人点赞了
     * @param momentId
     * @return
     */
    public Set<String> getMomentLikeUsers(long momentId) {
        return jedis.smembers("moment_like_users::" + momentId);
    }

    /**
     * 获取某条朋友圈的点赞数
     * @param momentId
     * @return
     */
    public long getMomentLikeUsersCount(long momentId) {
        return jedis.scard("moment_like_users::" + momentId);
    }

    public static void main(String[] args) {
        MomentsDemo demo = new MomentsDemo();
        // 你的用户id
        long userId = 1;
        // 你的朋友圈id
        long momentId = 150;
        // 你的朋友1的用户id
        long friendId = 2;
        // 你的朋友2的用户id
        long otherFriendId = 3;

        // 你的朋友1对你的朋友圈进行点赞
        demo.likeMoment(friendId, momentId);
        demo.dislikeMoment(friendId, momentId);
        boolean hasDislikedMoment = demo.hasDislikedMoment(friendId, momentId);
        System.out.println("朋友1点赞过：" +  (hasDislikedMoment ? "是" : "否"));
        // 你的朋友2对你的朋友圈进行点赞
        demo.likeMoment(otherFriendId, momentId);
        boolean hasDislikedMoment2 = demo.hasDislikedMoment(otherFriendId, momentId);
        System.out.println("朋友2点赞过：" +  (hasDislikedMoment2 ? "是" : "否"));

        // 你自己刷朋友圈，看自己的朋友圈的点赞情况
        Set<String> momentLikeUsers = demo.getMomentLikeUsers(momentId);
        long momentLikeUsersCount = demo.getMomentLikeUsersCount(momentId);
        System.out.println("朋友圈被" + momentLikeUsersCount + "个人点赞了，点赞的用户为：" + momentLikeUsers);


    }



}
