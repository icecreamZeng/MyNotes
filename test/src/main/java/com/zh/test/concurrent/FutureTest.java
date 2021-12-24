package com.zh.test.concurrent;

import com.google.common.util.concurrent.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/7 11:21
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1).thenApply(a -> a +1).thenApply(a -> a + 1);
        System.out.println(future.get());
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture listenableFuture = pool.submit(() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println("listenableFuture : " + i);
                Thread.sleep(1000);
            }
            return true;
        });

        Futures.addCallback(listenableFuture, new FutureCallback<Boolean>(){
            @Override
            public void onSuccess(Boolean o) {
                System.out.println("return is " + o);
                System.out.println(Thread.currentThread().getThreadGroup().activeCount());
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("fail");
            }
        }, pool);

        CompletableFuture.supplyAsync(() -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
                System.out.println("CompletableFuture: " + i);

            }
            return System.currentTimeMillis() - start;
        }).thenAccept(r -> {
            System.out.println("runtime : " + r + " ms");
            System.out.println(Thread.currentThread().getThreadGroup().activeCount());
            pool.shutdown();
            System.out.println("thread pool shutdown");
        });


        System.out.println("main thread end");
    }
}
