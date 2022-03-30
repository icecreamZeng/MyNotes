package com.zh.mynotes.algorithm.leetcode.interview.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zeng hao
 * @Description 面试题 04.01. 节点间通路
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 示例2:
 *
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 * 提示：
 *
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/03/30 13:51
 */
public class Interview0401 {
    public static void main(String[] args) {
        int n = 5;
        int[][] graph = {{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
        int start = 0;
        int target = 4;
        System.out.println(findWhetherExistsPath(n, graph, start, target));
    }

    /* 测试用例真的吐了，正向找跟反向找效果完全不一样。
    * 那是不是能瞒过所有用例就是最优算法？？？？？？
    * */
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer> path = new ArrayList<>();
        path.add(target);
        if (method(graph, path, start, target)){
            return true;
        }
        return false;
    }

    private static boolean method(int[][] graph, List<Integer> path, int start, int target) {
        if (start == target){
            return true;
        }
        for (int i = 0; i < graph.length; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            if (y == target && !path.contains(x)){
                path.add(x);
                if(method(graph, path, start, x)){
                    System.out.println(path.toString());
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
