package com.panson.concurrecy.example.commonUnsafe;

import com.panson.concurrecy.annotation.NotThreadSafe;
import com.panson.concurrecy.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

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
@ThreadSafe
public class StringExample2 {
    // 请求总数
    public static int clientTatal = 5000;

    // 同时并发执行的线程数
    public static int threadTatal = 200;

    public static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTatal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTatal);
        for (int i = 0; i < clientTatal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", stringBuffer.length());
    }

    private static void update() {
        stringBuffer.append("1");

    }
}
