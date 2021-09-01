package com.zh.test.concurrent;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/6 12:52
 */
public class SyncTest {
    private static boolean ready;
    private static int number;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (!ready){
                System.out.println(number);
            }
        }).start();
        Thread.sleep(1000);
        number=1;
        ready = true;


    }
}
