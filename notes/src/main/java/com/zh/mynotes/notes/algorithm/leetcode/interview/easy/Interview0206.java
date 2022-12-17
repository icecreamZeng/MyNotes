package com.zh.mynotes.notes.algorithm.leetcode.interview.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Zeng Hao
 * @Description:
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @Date: Created in 2021/8/25 18:19
 */
public class Interview0206 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);

        l1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode node = head;
        while (node != null){
            deque.push(node.val);
            node = node.next;
        }
        while (head != null){
            if (deque.isEmpty() || deque.poll() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //可以采用快慢指针的方式确定中间位置
    //然后反转后半段Node
    //最后与前半段比较
    //追究起来时间复杂度就是 '3n'
    //思考：时间复杂度和空间复杂度到底是怎样计算的？？？？
    public static boolean isPalindrome2(ListNode head){
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

