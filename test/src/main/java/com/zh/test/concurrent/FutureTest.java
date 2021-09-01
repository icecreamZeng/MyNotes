package com.zh.test.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/7 11:21
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1).thenApply(a -> a +1).thenApply(a -> a + 1);
        System.out.println(future.get());
    }
}
