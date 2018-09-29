package com.panson.concurrecy.example.publish;

import com.panson.concurrecy.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Package: com.panson.concurrecy.example.publish
 * Description：
 * Author: Panson
 */
@NotThreadSafe
@Slf4j
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
