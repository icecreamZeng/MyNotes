package com.zh.test.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/25 23:01
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        integer.incrementAndGet();

        System.out.println(integer.compareAndSet(1, 2));
        System.out.println(integer.get());
    }
}
