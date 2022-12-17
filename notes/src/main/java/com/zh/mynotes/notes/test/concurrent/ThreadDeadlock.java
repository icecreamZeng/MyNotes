package com.zh.mynotes.notes.test.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/12 14:02
 */
public class ThreadDeadlock {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> a = executorService.submit(() -> {
            for (int i = 0 ; i < 100 ;i ++){
                System.out.println("a + " + (i + 1));
                Thread.sleep(10000);
            }
            return 100;
        });
        Future<Integer> b = executorService.submit(() -> {
            for (int i = 0 ; i < 100 ;i ++){
                System.out.println("b + " + (i + 1));
                Thread.sleep(100);
            }
            return 200;
        });
        System.out.println(a.get() + b.get());
        executorService.shutdown();
        for (int i = 0 ; i < 100 ;i ++){
            System.out.println("main + " + (i + 1));
        }
    }
}
