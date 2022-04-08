package com.zh.mynotes.algorithm.leetcode.everyday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zeng hao
 * @Description 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * 
 *
 * 提示：
 *
 * 树的高度不会超过1000
 * 树的节点总数在 [0,10^4] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/08 10:43
 */
public class LevelOrder {


    public static void main(String[] args) {

    }

    public static List<List<Integer>> method(Node root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        list.add(root);
        do {
            List<Node> tmp = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            for (Node node : list) {
                if (node.children != null && !node.children.isEmpty()){
                    tmp.addAll(node.children);
                }
                l.add(node.val);
            }
            result.add(l);
            list.clear();
            list.addAll(tmp);
        }while (!list.isEmpty());
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
