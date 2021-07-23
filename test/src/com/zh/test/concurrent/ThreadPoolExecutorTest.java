package com.zh.test.concurrent;

import java.util.concurrent.*;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/12 15:42
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("exit");
        }));
        int coreNum = Runtime.getRuntime().availableProcessors();
        System.out.println(coreNum);
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 10, TimeUnit.SECONDS, blockingQueue);
        threadPoolExecutor.execute(() -> {
            for (int i = 0 ; i < 10 ;i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread a end");
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0 ; i < 10 ;i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread b end");
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0 ; i < 10 ;i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread c end");
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0 ; i < 10 ;i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread d end");
        });
        int count = 100;
        while (count -- >0){
            System.out.println(threadPoolExecutor.getPoolSize());
            Thread.sleep(1000);
        }
        threadPoolExecutor.shutdown();
    }
}
