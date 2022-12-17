package com.zh.mynotes.notes.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/12 15:42
 */
@Slf4j
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("exit");
        }));
        int coreNum = Runtime.getRuntime().availableProcessors();
        log.info(String.valueOf(coreNum));
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
            log.info("thread a end");
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0 ; i < 10 ;i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("thread b end");
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0 ; i < 10 ;i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("thread c end");
        });
        threadPoolExecutor.execute(() -> {
            for (int i = 0 ; i < 10 ;i ++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("thread d end");
        });
        int count = 100;
        while (count -- >0){
            log.info(String.valueOf(threadPoolExecutor.getPoolSize()));
            Thread.sleep(1000);
        }
        threadPoolExecutor.shutdown();
    }
}
