package top.panson.seckill.redis.hyperloglog;

import redis.clients.jedis.Jedis;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @Author: Panson
 */
public class WebsiteStatisticsDemo {

    private Jedis jedis = new Jedis("127.0.0.1");

    /**
     * 初始化 UV
     */
    public void initUVData(String date) {

        Random random = new Random();
        int startIndex = random.nextInt(1000);
        System.out.println("今日访问uv的起始id 为：" + startIndex);
        for (int i = startIndex; i < startIndex + 1358; i++) {
            for (int j = 0; j < 10; j++) {
                jedis.pfadd("hyperloglog_uv_" + date, String.valueOf(i + 1));
            }
        }
    }


    /**
     * 获取 UV
     * @return
     */
    public long getUV(String date) {
        return jedis.pfcount("hyperloglog_uv_" + date);
    }

//    /**
//     * 获取周活跃用户数量
//     * @return
//     */
//    public long getWeeklyUv() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar  = Calendar.getInstance();
//        calendar.setTime(new Date());
//
//    }

    public static void main(String[] args) {
        WebsiteStatisticsDemo demo = new WebsiteStatisticsDemo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(new Date());

        long duplicatedUv = 0;

        for(int i = 0; i < 7; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            String date = dateFormat.format(calendar.getTime());
            demo.initUVData(date);
//            long uv = demo.getUV();
//            System.out.println("日期为" + date + "的UV值为：" + demo.getUV());
        }
    }


}
