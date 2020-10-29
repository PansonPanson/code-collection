package top.panson.seckill.redis.set;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Author: Panson
 */
public class VoteDemo {

    private Jedis jedis = new Jedis("127.0.0.1");


    /**
     * 投票
     * @param userId
     * @param voteItemId
     */
    public void vote(long userId, long voteItemId) {
        jedis.sadd("vote_item_users::" + voteItemId, String.valueOf(userId));
    }

    /**
     * 检查是否投过票
     * @param userId
     * @param voteItemId
     * @return
     */
    public boolean hasVoted(long userId, long voteItemId) {
        return jedis.sismember("vote_item_users::" + voteItemId, String.valueOf(userId));
    }

    /**
     * 获取一个投票项被哪些人投票了
     * @param voteItemId
     * @return
     */
    public Set<String> getVoteItemUsers(long voteItemId) {
        return jedis.smembers("vote_item_users::" + voteItemId);
    }


    /**
     * 获取一个投票项被多少人投票了
     * @param voteItemId
     * @return
     */
    public long getVoteItemUsersCount(long voteItemId) {
        return jedis.scard("vote_item_users::" + voteItemId);
    }

    public static void main(String[] args) {
        VoteDemo demo = new VoteDemo();

        // 定义用户id
        long userId1 = 11111111;
        long userId2 = 2;
        long userId3 = 3;

        // 定义投票项id
        long voteItemId = 110;

        // 进行投票
        demo.vote(userId1, voteItemId);
        // 检查我是否投票过
        boolean hasVoted = demo.hasVoted(userId1, voteItemId);
        System.out.println("是否投票过：" + (hasVoted ? "是" : "否"));
        // 归票统计
        Set<String> voteItemUsers = demo.getVoteItemUsers(voteItemId);
        long voteItemUsersCount = demo.getVoteItemUsersCount(voteItemId);
        System.out.println("投票人有哪些：" + voteItemUsers + "，有多少人投票了：" + voteItemUsersCount );

    }






 }
