package com.zh.test.concurrent;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/30 22:48
 */
public class RunnableTest {

    static int DELAY = 10;
    static int STEPS = 100;

    public static void main(String[] args) {

        Runnable r = () -> {
          try {
              for (int i = 0; i < STEPS; i++) {
                  Thread.sleep((long) (DELAY * Math.random()));

              }
          }catch (InterruptedException e){}
        };
        r.run();
        Thread.currentThread().setDaemon(true);
    }
}
