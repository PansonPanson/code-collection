package com.panson.concurrecy.example.singleton;

import com.panson.concurrecy.annotation.NotThreadSafe;
import com.panson.concurrecy.annotation.ThreadSafe;

/**
 * Package: com.panson.concurrecy.example.singleton
 * Description：饿汉模式，单例实例在类装载时进行创建
 * Author: Panson
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2() {
    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
