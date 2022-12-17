package com.zh.mynotes.notes.algorithm.leetcode.interview.normal;

import java.util.*;

/**
 * @Author zeng hao
 * @Description 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 * 
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/03/30 15:57
 */
public class Interview0403 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        node4.left = node8;
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        node2.left = node4;
        node2.right = node5;
        TreeNode node7 = new TreeNode(7);
        TreeNode node3= new TreeNode(3);
        node3.right = node7;
        root.left = node2;
        root.right = node3;
        System.out.println(Arrays.toString(listOfDepth(root)));
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> listNodes = new ArrayList<>();
        Deque<TreeNode> childA = new ArrayDeque<>();
        Deque<TreeNode> childB = new ArrayDeque<>();
        childA.add(tree);
        ListNode listNode = new ListNode(tree.val);
        ListNode next = listNode;
        boolean isFirst = true;
        while (!childA.isEmpty()){
            TreeNode treeNode = childA.removeFirst();
            if (!isFirst){
                next.next = new ListNode(treeNode.val);
                next = next.next;
            }else {
                isFirst = false;
            }
            if (treeNode.left != null){
                childB.add(treeNode.left);
            }
            if (treeNode.right != null){
                childB.add(treeNode.right);
            }
            if (childA.isEmpty() && !childB.isEmpty()){
                childA.addAll(childB);
                childB.clear();
                listNodes.add(listNode);
                isFirst = true;
                listNode = new ListNode(childA.getFirst().val);
                next = listNode;
            }
        }
        listNodes.add(listNode);
        return listNodes.toArray(new ListNode[]{});
    }


}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
