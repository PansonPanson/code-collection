package com.panson.concurrecy.example.singleton;

import com.panson.concurrecy.annotation.Recommend;
import com.panson.concurrecy.annotation.ThreadSafe;

/**
 * Package: com.panson.concurrecy.example.singleton
 * Description：枚举模式;最安全
 * Author: Panson
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有构造函数
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }

}
