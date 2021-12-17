package com.zh.test.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/11/16 3:01
 */
public class CasTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.addAndGet(1);
        AtomicStampedReference<Integer> atomicReference = new AtomicStampedReference<>(1,1);

    }
}
