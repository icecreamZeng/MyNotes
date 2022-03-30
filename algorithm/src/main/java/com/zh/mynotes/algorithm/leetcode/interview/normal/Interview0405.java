package com.zh.mynotes.algorithm.leetcode.interview.normal;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author zeng hao
 * @Description 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *     根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/03/30 16:34
 */
public class Interview0405 {
    /**
     * 被恶心到了，我刚开始以为的是要 left < root < right,然后提示说 left <= root < right，然后用例需要满足 left < root < right
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        root.left = node1;
        root.right = node3;
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        AtomicBoolean result = new AtomicBoolean(true);
        method(root, result);
        return result.get();
    }

    private static int[] method(TreeNode root, AtomicBoolean result) {
        int min = root.val;
        int max = root.val;
        int mid = root.val;
        if (root.left != null){
            int[] left = method(root.left, result);
            if (!result.get()){
                return new int[]{mid, mid};
            }
            min = left[0];
            if (left[1] >= mid){
                result.set(false);
            }
        }
        if (root.right != null){
            int[] right = method(root.right, result);
            if (!result.get()){
                return new int[]{mid, mid};
            }
            max = right[1];
            if (right[0] <= mid){
                result.set(false);
            }
        }

        return new int[]{min, max};
    }
}

