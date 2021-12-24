package com.zh.test.concurrent;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/30 22:48
 */
public class RunnableTest {

    static int DELAY = 10;
    static int STEPS = 100;

    public static void main(String[] args) throws InterruptedException {

//        Runnable r = () -> {
//          try {
//              for (int i = 0; i < STEPS; i++) {
//                  Thread.sleep((long) (DELAY * Math.random()));
//
//              }
//          }catch (InterruptedException e){}
//        };
//        r.run();
//        Thread.currentThread().setDaemon(true);
        Object o = new Object();
        Runnable r1 = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    System.out.println("r1:" + i);
                    System.out.println(Thread.currentThread().getThreadGroup().activeCount());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                for (int i = 0; i < 20; i++) {
                    System.out.println("r2:" + i);
                    System.out.println(Thread.currentThread().getThreadGroup().activeCount());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        System.out.println("main end");
    }
}
