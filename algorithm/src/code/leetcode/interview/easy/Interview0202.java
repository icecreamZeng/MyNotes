package code.leetcode.interview.easy;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 02.02. 返回倒数第 k 个节点
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k保证是有效的。
 *
 * @Date: Created in 2021/7/20 18:56
 */
public class Interview0202 {
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
        //System.out.println(kthToLast(node, 2));
        System.out.println(kthToLast3(node, 2));
    }
    public static int kthToLast(ListNode head, int k) {
        ListNode first = head;
        ListNode node = head.next;
        first.next = null;
        ListNode next = null;
        while (node != null){
            next = node.next;
            node.next = first;
            first = node;
            node = next;
        }
        ListNode node2 = first;
        for (int i = 1; i < k ; i ++){
            node2 = node2.next;
        }
        return node2 == null ? 0 : node2.val;
    }

    public static int kthToLast2(ListNode head, int k){
        return method(head, k , new AtomicInteger(1));
    }

    public static int method(ListNode node, int k, AtomicInteger ix){
        ListNode next = node.next;
        int item = node.val;
        if (next != null) {
            int result = method(next, k, ix);
            if (ix.addAndGet(1) != k) {
                return result;
            }
        }
        return item;
    }

    public static int kthToLast3(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            if (k -- <= 0){
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow.val;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
