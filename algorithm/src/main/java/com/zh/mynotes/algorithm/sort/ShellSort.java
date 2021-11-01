package com.zh.mynotes.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Zeng Hao
 * @Description: 希尔排序
 * 希尔排序可以算是 插入排序的进阶版，在此基础上 加了 一个比较增量的概念，可以理解为插入排序就是 增量为1的希尔排序。
 * 希尔排序的重点在于如何设置合理的增量, 数据长度为 n , 一般依次设置为 n/2、n/4、n/8.....1,在每个增量上进行插入排序，直到增量为1.
 * @Date: Created in 2021/1/14 14:48
 */
public class ShellSort {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(method(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
        count.set(0);
        System.out.println(Arrays.toString(method2(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
    }

    private static int[] method(int[] arr) {
        int length = arr.length;
        //第一次的增量为 n/2,每次都执行插入排序，直到 增量 = 1
        int increment = length / 2;
        while (increment >= 1){

        }

        return arr;
    }
    private static int[] method2(int[] arr) {
        return arr;
    }
}
