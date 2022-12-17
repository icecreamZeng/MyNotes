package com.zh.mynotes.notes.algorithm.leetcode.interview.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Zeng Hao
 * @Description: 傻逼题目，描述是错误，用例也是错了，相互矛盾。
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 * 提示：
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 *
 * @Date: Created in 2021/8/26 8:55
 */
public class Interview0207 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        l1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode l2 = new ListNode(5);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(4);
        ListNode node10 = new ListNode(5);
        l2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        ListNode result = method(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    //最先想到的是 直接用栈结构存储节点
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Deque<ListNode> dequeA = new ArrayDeque<>();
        Deque<ListNode> dequeB = new ArrayDeque<>();
        while(headA != null || headB != null){
            if (headA != null){
                dequeA.push(headA);
                headA = headA.next;
            }
            if (headB != null){
                dequeB.push(headB);
                headB = headB.next;
            }
        }
        ListNode node = null;
        while(!dequeA.isEmpty() && ! dequeB.isEmpty()){
            ListNode nodeA = dequeA.pop();
            ListNode nodeB = dequeB.pop();
            //跑用例时 nodeA == nodeB
            //为啥会有这种设定？？？
            if (nodeA.val == nodeB.val){
                node = nodeA;
            }
        }
        return node;
    }

    //如果不采用额外的数据结构的话，还是得先知道链表的长度，不然无法得知两个链表长度的偏差
    //这里能不能用到快慢指针？
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        return null;
    }

    //大佬的方法，有点快慢指针的意思
    //不过要遍历多次，直到两个指针末端对齐
    public static ListNode method(ListNode headA, ListNode headB){
        ListNode h1 = headA, h2 = headB;

        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
