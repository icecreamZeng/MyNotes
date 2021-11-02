package com.zh.mynotes.algorithm.leetcode.interview.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.09. 二叉搜索树序列
 *  
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * 给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 * 
 * 示例：
 * 给定如下二叉树

        2
       / \
      1   3
 * 返回：
 * [
 * [2,1,3],
 * [2,3,1]
 * ]
 */
public class Interview0409 {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeNode node2 = new TreeNode(2);
        TreeNode node9 = new TreeNode(9);
        TreeNode node5 = new TreeNode(5);
        node5.left = node2;
        node5.right = node9;

        TreeNode node13 = new TreeNode(13);
        TreeNode node17 = new TreeNode(17);
        TreeNode node15 = new TreeNode(15);
        node15.left = node13;
        node15.right = node17;

        TreeNode node19 = new TreeNode(19);
        node19.left = node15;

        root.left = node5;
        root.right = node19;
        res = BSTSequences(root);
        if (!res.isEmpty()){
            for (int i = 0; i < res.size(); i++) {
                System.out.println("第"+ i +"种情况");
                System.out.println(res.get(i));
            }
        }
    }


    // 父节点一定是排在子节点之前
    // 左右子树并没有先后关系
    // 左右子树只要各自满足父节点在前就行，而左右子树的节点可以互相穿插，没有连贯性限制。
    // 理论上可以先默认按照 父、左、右 找出第一种排列顺序，然后依此延展出其他可能

    //
    public static List<List<Integer>> BSTSequences(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if (root != null){
            list.add(root);
        }
        method(path, list);
        return res;
    }

    private static void method(List<Integer> path, List<TreeNode> list) {
        if (list.isEmpty()){
            res.add(new ArrayList<>(path));
            return;
        }
        List<TreeNode> copy = new ArrayList<>(list);
        int size = list.size();
        for (int i = 0 ; i < size ; i ++){
            TreeNode node = list.get(i);
            path.add(node.val);
            list.remove(i);
            if (node.left != null){ list.add(node.left); }
            if (node.right != null){ list.add(node.right); }
            method(path, list);
            path.remove(path.size() -1 );
            list = new ArrayList<>(copy);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
 
        TreeNode(int x) {
            val = x;
        }
    }    
    
}


