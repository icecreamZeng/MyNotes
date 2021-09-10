package com.zh.mynotes.algorithm.leetcode.interview.easy;

/*
 * @Author: icecream.zeng
 * @Date: 2021-09-01 16:15:31 
 * @Description: 
 * 
 * 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * 
 * 示例1:
 * 
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 
 * 示例2:
 * 
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 * 
 * 提示：
 * 
 * 0 <= stackNum <= 2
 */
public class Interview0301 {


    public static void main(String[] args) {
        
    }

    int[] arr;
    int stackSize;
    int[] indexs;

    public Interview0301(int stackSize) {
        arr = new int[stackSize * 3];
        this.stackSize = stackSize;
        indexs = new int[]{-3, -2, -1};
    }
    
    public void push(int stackNum, int value) {
        int index = indexs[stackNum] + 3;
        if(index >= arr.length){
            return;
        }
        arr[index] = value;
        indexs[stackNum] = index;
    }
    
    public int pop(int stackNum) {
        if(isEmpty(stackNum)){
            return -1;
        }
        int index = indexs[stackNum];
        int value = arr[index];
        indexs[stackNum] = index -3;
        return value;
    }
    
    public  int peek(int stackNum) {
        if(isEmpty(stackNum)){
            return -1;
        }
        return arr[indexs[stackNum]];
    }
    
    public boolean isEmpty(int stackNum) {
        return indexs[stackNum] < 0;
    }
}
