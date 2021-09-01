package com.zh.mynotes.algorithm.leetcode.interview.normal;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 02.04. 分割链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 示例1：
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 示例2:
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * @Date: Created in 2021/7/23 3:20
 */
public class Interview0204 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        ListNode result = partition(node, 0);
        System.out.println("==================");
        do {
            System.out.println(result.val);
            result = result.next;
        }while (result != null);
    }

    //题目是真的有没说清楚，其实可以不用再保持相对顺序。遵循的规则只有一条，比 x 小 的节点在前面，但互相没有限制。
    public static ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode smaller = null;
        ListNode node  = head;
        ListNode bigger = null;
        ListNode first = null;
        ListNode second = null;
        ListNode next = head;
        do {
            next = next.next;
            int val = node.val;
            if(val < x){
                if (smaller == null){
                    smaller = node;
                    first = node;
                }else{
                    smaller.next = node;
                    smaller = node;
                }
                smaller.next = null;
            }else {
                if (bigger == null){
                    bigger = node;
                    second = node;
                }else  {
                    bigger.next = node;
                    bigger = node;
                }
                bigger.next = null;
            }
            node = next;
        }while (node != null);
        if (first == null){
            return second;
        }else{
            smaller.next  = second;
            return first;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
