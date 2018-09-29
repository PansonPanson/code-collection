package com.panson.concurrecy.example.commonUnsafe;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Package: com.panson.concurrecy.example.commonUnsafe
 * Description：
 * Author: Panson
 */
@Slf4j
public class HashMapExample {

    // 请求总数
    public static int clientTatal = 5000;

    // 同时并发执行的线程数
    public static int threadTatal = 200;

    private static Map<Integer, Integer> map = new HashMap<>();

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
