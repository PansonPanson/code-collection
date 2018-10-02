package com.panson.concurrecy.example.syncContainer;

import com.panson.concurrecy.annotation.NotThreadSafe;

import java.util.Vector;

/**
 * Package: com.panson.concurrecy.example.syncContainer
 * Description：
 * Author: Panson
 */
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    // 数组会越界
    public static void main(String[] args) {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();

        }
    }
}
