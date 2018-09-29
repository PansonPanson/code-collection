package com.panson.concurrecy.example.singleton;

import com.panson.concurrecy.annotation.NotRecommend;
import com.panson.concurrecy.annotation.NotThreadSafe;
import com.panson.concurrecy.annotation.ThreadSafe;

/**
 * Package: com.panson.concurrecy.example.singleton
 * Description：懒汉模式，单例实例在第一次使用时进行创建
 * Author: Panson
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3() {
    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
