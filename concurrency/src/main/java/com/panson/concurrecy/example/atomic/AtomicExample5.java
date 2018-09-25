package com.panson.concurrecy.example.atomic;

import com.panson.concurrecy.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Package: com.panson.concurrecy.example.atomic
 * Description：AtomicIntegerFieldUpdater
 * 更新某个字段的值，同时这个字段必须使用Volatile修饰且不为static
 * Author: Panson
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;


    public static void main(String[] args) {

        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success {}", example5.getCount());
        } else {
            log.info("update failed {}", example5.getCount());

        }
    }
}
