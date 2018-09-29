package com.panson.concurrecy.example.singleton;

import com.panson.concurrecy.annotation.ThreadSafe;

/**
 * Package: com.panson.concurrecy.example.singleton
 * Description：懒汉模式 volatile + 双重检测机制 来禁止指令重排
 * Author: Panson
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数
    private SingletonExample5() {
    }

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance 初始化对象
    // 3. instance = memory 设置instance指向刚分配的内存


    // 单例对象
    // volatile适用场景：
    // 1. 状态标识量
    // 2. 双重检测
    private volatile static SingletonExample5 instance = null;

    // 静态的工厂方法
    public static synchronized SingletonExample5 getInstance() {
        if (instance == null) { //双重检测机制  // B
            synchronized (SingletonExample5.class) {  // 同步锁
                if (instance == null) {
                    instance = new SingletonExample5(); // A-3
                }
            }
        }
        return instance;
    }
}
