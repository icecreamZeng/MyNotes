package com.zh.mynotes.algorithm.leetcode.everyday.normal;

import java.util.*;

/**
 * @Author zeng hao
 * @Description 2196. 根据描述创建二叉树
 * 给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：
 *
 * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
 * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
 * 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
 *
 * 测试用例会保证可以构造出 有效 的二叉树。
 *
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
 * 输出：[50,20,80,15,17,19]
 * 解释：根节点是值为 50 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 * 示例 2：
 *
 *
 *
 * 输入：descriptions = [[1,2,1],[2,3,0],[3,4,1]]
 * 输出：[1,2,null,null,3,4]
 * 解释：根节点是值为 1 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 * 
 *
 * 提示：
 *
 * 1 <= descriptions.length <= 10^4
 * descriptions[i].length == 3
 * 1 <= parenti, childi <= 10^5
 * 0 <= isLefti <= 1
 * descriptions 所描述的二叉树是一棵有效二叉树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-binary-tree-from-descriptions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/09 20:29
 */
public class CreateBinaryTree {
    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        System.out.println(createBinaryTree(descriptions));
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions == null){
            return null;
        }
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> rootSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];
            TreeNode parentNode = map.get(parent);
            if (parentNode == null){
                parentNode = new TreeNode(parent);
                map.put(parent, parentNode);
            }
            TreeNode childNode = map.get(child);
            if (childNode == null){
                childNode = new TreeNode(child);
                map.put(child, childNode);
            }
            if (isLeft == 1){
                parentNode.left = childNode;
            }else{
                parentNode.right = childNode;
            }
            childSet.add(child);
            if (!childSet.contains(parent)){
                rootSet.add(parent);
            }
            rootSet.remove(child);
        }
        int root = rootSet.iterator().next();
        return map.get(root);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
 }
