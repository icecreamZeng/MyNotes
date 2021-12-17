package com.zh.mynotes.algorithm.sort;

import java.util.Arrays;

/**
 * @Author zeng hao
 * @Description 堆排序
 * @Date Create in 2021/11/16 4:30
 */
public class HeapSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(method(new int[]{26,3,2,45,9,7,4,1,2,77,6})));
    }

    //按最小堆来排序
    //1.父节点<子节点
    private static int[] method(int[] arr){
        int[] minHeap = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            siftUp(minHeap,i, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap[0];
            siftDownMax(minHeap, arr.length - i);
        }
        return arr;
    }

    //节点 i 的 左右节点分别是 2*i +1和 2*i+2，父节点是 (i-1)/2
    private static void siftUp(int[] arr, int length, int x){
        arr[length] = x;
        if (length++ == 0){
            return;
        }
        for (int i = length - 1 ; i > 0; i = (i - 1) / 2) {
            int parent = (i-1)/2;
            if (arr[parent] > arr[i]){
                int temp = arr[parent];
                arr[parent] = arr[i];
                arr[i] = temp;
            }
            if (parent == 0){
                break;
            }
        }
    }
    private static void siftDownMax(int[] arr, int length){
        arr[0] = arr[length - 1];
        length--;
        if (length <= 0){
            return;
        }
        for (int i = 0; i < length; ) {
            int leftIndex = i*2 + 1;
            int rightIndex = i*2 + 2;
            int left = leftIndex < length ? arr[leftIndex] : Integer.MAX_VALUE;
            int right = rightIndex < length ? arr[rightIndex] : Integer.MAX_VALUE;
            if (arr[i] <= Math.min(left, right)){
                break;
            }
            if (left == Math.min(left, right)){
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[i];
                arr[i] = temp;
                i = leftIndex;
            }else {
                int temp = arr[rightIndex];
                arr[rightIndex] = arr[i];
                arr[i] = temp;
                i = rightIndex;
            }
        }
    }
}
