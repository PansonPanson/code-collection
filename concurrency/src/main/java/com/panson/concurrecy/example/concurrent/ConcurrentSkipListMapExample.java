package com.panson.concurrecy.example.concurrent;

import com.panson.concurrecy.annotation.NotThreadSafe;
import com.panson.concurrecy.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Package: com.panson.concurrecy.example.commonUnsafe
 * Description：
 * Author: Panson
 */
@Slf4j
@ThreadSafe
public class ConcurrentSkipListMapExample {

    // 请求总数
    public static int clientTatal = 5000;

    // 同时并发执行的线程数
    public static int threadTatal = 200;

    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTatal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTatal);
        for (int i = 0; i < clientTatal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", map.size());

    }

    private static void update(int i) {

        map.put(i, i);
    }
}