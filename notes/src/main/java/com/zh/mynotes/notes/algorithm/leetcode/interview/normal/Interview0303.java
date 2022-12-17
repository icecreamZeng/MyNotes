package com.zh.mynotes.notes.algorithm.leetcode.interview.normal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 描述：面试题 03.03. 堆盘子
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。
 * 因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
 * 请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 * 此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * 当某个栈为空时，应当删除该栈。
 * 当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * 
 * 示例1:
 *  输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * 
 * 示例2:
 *  输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 */
public class Interview0303 {
    public static void main(String[] args) {
        
    }

    List<Deque<Integer>> stacks;
    int cap;

    public Interview0303(int cap){
        this.cap = cap;
        stacks = new ArrayList<>();
    }

    public void push(int val) {
        if(cap <= 0){
            return;
        }
        Deque<Integer> deque;
        if(stacks.isEmpty()){
            deque = new ArrayDeque<>();
            stacks.add(deque);
        }else{
            deque = stacks.get(stacks.size() -1);
        }
        if(deque.size() < cap || cap <= 0){
            deque.push(val);
        }else{
            Deque<Integer> newDeque = new ArrayDeque<>();
            newDeque.push(val);
            stacks.add(newDeque);
        }
    }
    
    public int pop() {
        if(stacks.isEmpty()){
            return -1;
        }
        Deque<Integer> deque = stacks.get(stacks.size() -1);
        int value = deque.pop();
        if(deque.isEmpty()){
            stacks.remove(deque);
        }
        return value;
    }
    
    public int popAt(int index) {
        if(cap <= 0 || stacks.size() <= index){
            return -1;
        }
        Deque<Integer> deque = stacks.get(index);
        int value = deque.pop();
        if(deque.isEmpty()){
            stacks.remove(deque);
        }
        return value;
    }
}
