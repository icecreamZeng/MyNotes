package com.zh.mynotes.notes.algorithm.sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Zeng Hao
 * @Description: 快速排序
 * @Date: Created in 2021/1/13 23:12
 */
public class QuickSort {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(method(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
        count.set(0);
        System.out.println(Arrays.toString(method2(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
    }
    private static int[] method(int[] arr) {
        Deque<Integer> leftQueue = new ArrayDeque<>();
        Deque<Integer> rightQueue = new ArrayDeque<>();
        leftQueue.push(0);
        rightQueue.push(arr.length - 1);
        while (!leftQueue.isEmpty()){
            int left = leftQueue.pollLast();
            int right = rightQueue.pollLast();
            if (left >= right){
                continue;
            }
            int index = left;
            int waitSortElement = arr[left];
            for (int i = left + 1 ; i <= right ; i ++){
                count.getAndAdd(1);
                if (waitSortElement > arr[i]){
                    //两次交换 第一次 将被比较的元素与 index + 1 交换
                    //第二次index 与index +1 交换
                    if (i > index + 1){
                        swap(arr, index + 1 , i);
                    }
                    swap(arr, index, index + 1);
                    index ++;
                }
            }
            //放入两个 无序数组
            leftQueue.push(left);
            rightQueue.push(index - 1);
            leftQueue.push(index + 1);
            rightQueue.push(right);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int[] method2(int[] arr){
        return recursion(arr, 0, arr.length - 1);
    }

    private static int[] recursion(int[] arr, int left, int right){
        if (left >= right){
            return arr;
        }
        int index = left;
        int waitSortElement = arr[left];
        for (int i = left + 1 ; i <= right ; i ++){
            count.getAndAdd(1);
            if (waitSortElement > arr[i]){
                //两次交换 第一次 将被比较的元素与 index + 1 交换
                //第二次index 与index +1 交换
                if (i > index + 1){
                    swap(arr, index + 1 , i);
                }
                swap(arr, index, index + 1);
                index ++;
            }
        }
        arr = recursion(arr, left, index - 1);
        return recursion(arr, index + 1 , right);
    }
}
