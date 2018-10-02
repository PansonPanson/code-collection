package com.panson.concurrecy.example.syncContainer;

import com.panson.concurrecy.annotation.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * Package: com.panson.concurrecy.example.syncContainer
 * Description：在使用迭代器或者for each 做循环操作的时候，不要做remove操作和更新操作，
 *              如果非要使用，建议在遍历过程中做好标记，在遍历之后再删除
 * Author: Panson
 */
@NotThreadSafe
public class VectorExample3 {

    // Exception in thread "main" java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1) {
        for (Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // Exception in thread "main" java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1) { // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }
    // success
    private static void test3(Vector<Integer> v1) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }
    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}
