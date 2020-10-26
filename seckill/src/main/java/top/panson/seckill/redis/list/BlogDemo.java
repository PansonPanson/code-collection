package top.panson.seckill.redis.list;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @Author: Panson
 */
public class BlogDemo {


    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 发表博客
     *
     * @param id
     * @param blog
     * @return
     */
    public boolean publishBlog(long id, Map<String, String> blog) {
        if(jedis.hexists("article::" + id, "title")) {
            return false;
        }
        blog.put("content_length", String.valueOf(blog.get("content").length()));
        jedis.hmset("article::" + id, blog);
        jedis.lpush("blog_list", String.valueOf(id));

        return true;
    }

    /**
     * 查找博客
     *
     * @param id
     * @return
     */
    public Map<String, String> findBlogById(long id) {
        Map<String, String> blog = jedis.hgetAll("article::" + id);
        incrementBlogViewCount(id);
        return blog;
    }

    private void incrementBlogViewCount(long id) {

    }

    /**
     * 分页查询博客
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<String> findBlogByPage(int pageNo, int pageSize) {
        int startIndex = (pageNo - 1) * pageSize;
        int endIndex = pageNo * pageSize - 1;
        return jedis.lrange("blog_list", startIndex, endIndex);
    }




}
