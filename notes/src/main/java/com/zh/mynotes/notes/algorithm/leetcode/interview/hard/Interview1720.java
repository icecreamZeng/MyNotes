package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author zeng hao
 * @Description 面试题 17.20. 连续中值
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 *
 * [2,3,4]的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * @Date Create in 2021/11/08 2:17
 */
public class Interview1720 {

    static Queue<Integer> little;
    static Queue<Integer> big;

    public static void main(String[] args) {
        MedianFinder();
    }

    /** initialize your data structure here. */
    public static void MedianFinder() {
        little = new PriorityQueue<>(Collections.reverseOrder());
        big = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (little.isEmpty()){
            little.add(num);
            return;
        }
        int littleNum = little.peek();
        if (big.size() == little.size()){
            int bigNum = big.peek();
            if (bigNum < num){
                big.remove();
                little.add(bigNum);
                big.add(num);
            }else{
                little.add(num);
            }
        }else{
            if (littleNum > num){
                little.remove();
                big.add(littleNum);
                little.add(num);
            }else{
                big.add(num);
            }
        }
    }

    public double findMedian() {
        if (little.size() > big.size()){
            return little.peek();
        }else {
            return (little.peek() + big.peek())/2.0;
        }
    }
}
