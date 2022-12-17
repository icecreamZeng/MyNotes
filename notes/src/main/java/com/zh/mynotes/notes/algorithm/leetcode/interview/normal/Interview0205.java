package com.zh.mynotes.notes.algorithm.leetcode.interview.normal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 02.05. 链表求和
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。89
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * @Date: Created in 2021/8/3 20:03
 */
public class Interview0205 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);
        l1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(4);
        l2.next = node5;
        node5.next = node6;

        ListNode result = addTwoNumbers2(l1, l2);
        System.out.println("==================");
        do {
            System.out.println(result.val);
            result = result.next;
        }while (result != null);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int offset = 0;
        ListNode result = null;
        ListNode node = null;
        while (l1 != null || l2 != null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + offset;
            offset = sum >= 10 ? 1 : 0;
            if (node == null){
                result = new ListNode(sum % 10);
                node = result;
            }else{
                node.next = new ListNode(sum % 10);
                node = node.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(offset > 0){
            node.next = new ListNode(1);
        }
        return result;
    }

    //数字倒过来怎么计算呢？
    //结算两数之和是不是必须得从个位开始？
    //如果可以从最高位计算，怎么解决进位的问题？
    //如果两个数最高位不相同该怎么计算？
    //这样的话还是得先得到最低位？那是否可以考虑递归？
    //为什么会忘了 stack 这种数据结构呢？？？？？？？？？？？
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        Deque<Integer> numberA = new ArrayDeque<>();
        Deque<Integer> numberB = new ArrayDeque<>();
        while(l1 != null || l2 != null ){
            if(l1 != null){
                numberA.push(l1.val);
                l1 = l1.next;
            }
            if(l2 != null){
                numberB.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode result = null;
        int offset = 0;
        while(!numberA.isEmpty() || !numberB.isEmpty()){
            int numA = numberA.isEmpty() ? 0 : numberA.pop();
            int numB = numberB.isEmpty() ? 0 : numberB.pop();
            int sum = numA + numB + offset;
            offset = sum >= 10 ? 1 : 0;
            ListNode node = new ListNode(sum % 10);
            node.next = result;
            result = node;
        }
        if  (offset > 0){
            ListNode node = new ListNode(offset);
            node.next = result;
            result = node;
        }
        return result;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
