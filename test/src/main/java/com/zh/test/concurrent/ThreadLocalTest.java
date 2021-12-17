package com.zh.test.concurrent;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/11/27 21:38
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(123);
        threadLocal.get();
    }
}
