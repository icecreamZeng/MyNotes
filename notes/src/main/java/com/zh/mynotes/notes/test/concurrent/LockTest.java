package com.zh.mynotes.notes.test.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/6 12:22
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Runnable r1 = () -> {
            System.out.println("r1 run");
            lock.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                int i = 10000;
                while (i > 0){
                    System.out.println("r1 lock , i = " + i);
                    i --;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }
            System.out.println("r1 end");
        };
        Runnable r2 = () -> {
            System.out.println("r2 run");
            lock.lock();
            try {
                int i = 10;
                while (i > 0){
                    System.out.println("r2 lock , i = " + i);
                    i --;
                }

            }finally {
                lock.unlock();
            }
            System.out.println("r2 end");
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        Thread.sleep(100);
        t2.start();
        System.out.println("main end");
    }
}
