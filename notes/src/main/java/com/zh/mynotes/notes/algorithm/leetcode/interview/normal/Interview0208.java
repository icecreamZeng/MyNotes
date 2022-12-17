package com.zh.mynotes.notes.algorithm.leetcode.interview.normal;

/**
 * @Author: Zeng Hao
 * @Description:
 *
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 进阶：
 *
 * 你是否可以不用额外空间解决此题？
 * @Date: Created in 2021/8/26 11:28
 */
public class Interview0208 {
    
    public static void main(String[] args) {
        System.out.println(detectCycle(null));
    }

    //这实际是一道数学问题，
    //设链表起点到环入口的距离为a,
    //设环长为b,
    //设置两个快慢指针，快指针走每走两步，慢指针走一步,
    //如果快慢指针相遇到环入口的距离是x,则有：
    // (a + x) * 2 = a + b + x 或  (a + x) * 2 = a + b + b + x 或   (a + x) * 2 = a + b + b + b + x 或 (a + b + x) * 2 = a + b + b + b + x ....
    //得到 a + x = n * b
    // 所以，第一次相遇后，如果让一个快指针从链表起点与慢指针速度相同出发，再次相遇地点一定是环入口。
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do{
          if(fast == null || slow == null){
              return null;
          }
          slow = slow.next;
          fast = fast.next;
          if(fast == null){
              return null;
          }
          fast = fast.next;
        }while(fast != slow);
        if(fast == null || slow == null){
            return null;
        }
        if(slow == head){
            return head;
        }
        fast = head;
        do{
            slow = slow.next;
            fast = fast.next;
          }while(fast != slow);
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
