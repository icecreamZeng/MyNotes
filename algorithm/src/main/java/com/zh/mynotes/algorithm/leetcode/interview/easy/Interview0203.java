package com.zh.mynotes.algorithm.leetcode.interview.easy;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 02.03. 删除中间节点
 *
 * 若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
 *
 * 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
 *
 * 例如，传入节点c（位于单向链表a->b->c->d->e->f中），将其删除后，剩余链表为a->b->d->e->f
 *
 * 示例：
 *
 * 输入：节点5（位于单向链表4->5->1->9中）
 * 输出：不返回任何数据，从链表中删除传入的节点 5，使链表变为4->1->9
 *
 * @Date: Created in 2021/7/23 3:05
 */
public class Interview0203 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        deleteNode(node4);
    }

    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
