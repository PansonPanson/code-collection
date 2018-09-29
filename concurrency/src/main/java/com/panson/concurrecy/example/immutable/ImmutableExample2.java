package com.panson.concurrecy.example.immutable;

import com.google.common.collect.Maps;
import com.panson.concurrecy.annotation.NotThreadSafe;
import com.panson.concurrecy.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * Package: com.panson.concurrecy.example.immutable
 * Description：
 * Author: Panson
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private final static Integer a = 1;
    private final static String b = "2";
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }


}
