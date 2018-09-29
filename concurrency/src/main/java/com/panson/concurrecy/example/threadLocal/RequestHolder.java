package com.panson.concurrecy.example.threadLocal;

/**
 * Package: com.panson.concurrecy.example.threadLocal
 * Description：
 * Author: Panson
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
