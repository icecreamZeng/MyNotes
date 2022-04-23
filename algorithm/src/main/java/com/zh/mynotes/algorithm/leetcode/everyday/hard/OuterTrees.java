package com.zh.mynotes.algorithm.leetcode.everyday.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zeng hao
 * @Description 587. 安装栅栏
 * 在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * 输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * 解释:
 *
 * 示例 2:
 *
 * 输入: [[1,2],[2,2],[4,2]]
 * 输出: [[1,2],[2,2],[4,2]]
 * 解释:
 *
 * 即使树都在一条直线上，你也需要先用绳子包围它们。
 * 
 *
 * 注意:
 *
 * 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。
 * 输入的整数在 0 到 100 之间。
 * 花园至少有一棵树。
 * 所有树的坐标都是不同的。
 * 输入的点没有顺序。输出顺序也没有要求。
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/erect-the-fence">https://leetcode-cn.com/problems/erect-the-fence</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/23 14:19
 */
public class OuterTrees {

    public static void main(String[] args) {
        int[][] trees = {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        method(trees);
    }

    public static int[][] method(int[][] trees) {
        int n = trees.length;
        if (n < 4){
            return trees;
        }
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i][0] < trees[left][0]){
                left = i;
            }
        }
        List<int[]> res = new ArrayList<>();
        boolean[] visit = new boolean[n];
        int p = left;
        do {
            int q = (p + 1) % n;
            for (int r = 0; r < n; r++) {
                if (cross(trees[p], trees[q], trees[r]) < 0){
                    q = r;
                }
            }
            for (int i = 0; i < n; i++) {
                if (visit[i] || i == p || i == q){
                    continue;
                }
                if (cross(trees[p], trees[q], trees[i]) == 0){
                    res.add(trees[i]);
                    visit[i] = true;
                }
            }
            if (!visit[q]){
                res.add(trees[q]);
                visit[q] = true;
            }
            p = q;
        }while (p != left);
        return res.toArray(new int[][]{});
    }

    public static int cross(int[]p, int[] q, int []r){
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }
}
