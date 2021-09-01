package leetcode.interview.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 02.01. 移除重复节点
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * @Date: Created in 2021/7/20 18:10
 */
public class Interview0201 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode first = node;
        do {
            System.out.println(first.val);
            first = first.next;
        }while (first != null);
        System.out.println("==================");
        ListNode second = removeDuplicateNodes2(node);

        System.out.println("==================");
        do {
            System.out.println(second.val);
            second = second.next;
        }while (second != null);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        set.add(node.val);
        ListNode next = head.next;
        do {
            int val = next.val;
            node.next = null;
            if (!set.contains(val)){
                System.out.println("mark");
                System.out.println(val);
                set.add(val);
                node.next = next;
                node = next;
            }
            next = next.next;
        }while (next != null);
        return head;
    }

    public static ListNode removeDuplicateNodes2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        ListNode next = head.next;
        do {
            node.next = null;
            ListNode tmp = head;
            boolean check = true;
            while (tmp != null){
                if (tmp.val == next.val){
                    check = false;
                    break;
                }
                tmp = tmp.next;
            }
            if (check){
                node.next = next;
                node = next;
            }
            next = next.next;
        }while (next != null);
        return head;
    }

     static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

