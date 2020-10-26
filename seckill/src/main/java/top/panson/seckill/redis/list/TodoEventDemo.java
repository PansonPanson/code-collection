package top.panson.seckill.redis.list;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ListPosition;

import java.util.List;

/**
 * @Author: Panson
 */
public class TodoEventDemo {

    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 添加待办事项
     * @param id
     * @param todoEvent
     */
    public void addTodoEvent(long id, String todoEvent) {
        jedis.lpush("todo_event::" + id, todoEvent);
    }

    /**
     * 分页查询待办事项列表
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<String> findTodoEventByPage(long userId, int pageNo, int pageSize) {
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = pageNo * pageSize - 1;
        return jedis.lrange("todo_event::" + userId, startIndex, endIndex);
    }

    /**
     * 插入待办事项
     *
     * @param userId
     * @param position
     * @param todoEvent
     * @param targetTodoEvent
     */
    public void insertTodoEvent(long userId, ListPosition position, String targetTodoEvent, String todoEvent) {
        jedis.linsert("todo_event::" + userId, position, targetTodoEvent, todoEvent);
    }

    /**
     * 完成一个待办事项
     * @param userId
     * @param todoEvent
     */
    public void finishTodoEvent(long userId, String todoEvent) {
        jedis.lrem("todo_event::" + userId, 0, todoEvent);
    }

    public void updateTodoEvent(long userId, int index, String updatedTodoEvent) {
        jedis.lset("todo_event" + userId, index, updatedTodoEvent);
    }


}
