package com.panson.concurrecy.example.publish;

import com.panson.concurrecy.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Package: com.panson.concurrecy.example.publish
 * Description：
 * Author: Panson
 */
@Slf4j
@NotThreadSafe
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
