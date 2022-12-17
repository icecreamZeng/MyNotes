package com.zh.mynotes.notes.algorithm.leetcode.interview.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 描述：面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class Interview0302 {
    Deque<Integer> valueDeque;
    Deque<Integer> minDeque;

    public static void main(String[] args) {
        
    }
    
    /** initialize your data structure here. */
    public Interview0302() {
        valueDeque = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }
    
    public void push(int x) {
        valueDeque.push(x);
        minDeque.push(Math.min(getMin(), x));
    }
    
    public void pop() {
        valueDeque.pop();
        minDeque.pop();
    }
    
    public int top() {
        return valueDeque.peek();
    }
    
    public int getMin() {
        if(minDeque.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minDeque.peek();
    }
}
