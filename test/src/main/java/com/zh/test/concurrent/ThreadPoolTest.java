package com.zh.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/7 11:56
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i =0; i < 10 ;i++){
            final int count = i + 1;
            Runnable r = () -> {
                try {
                    Thread.sleep(1000);
                    //Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count);
            };
            executorService.execute(r);
        }
        executorService.shutdown();
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(11);
        };
        executorService.execute(r);

    }


}
