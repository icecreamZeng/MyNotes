package com.zh.mynotes.notes.test.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2021/11/18 3:28
 */
public class LockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();

    }
}
