package com.zh.mynotes.notes.algorithm.leetcode.everyday.normal;

import java.util.Arrays;

/**
 * @Author zeng hao
 * @Description 1334.阈值距离内邻居最少的城市
 * @see <a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/?envType=list&envId=3R99x1zJ">1334.阈值距离内邻居最少的城市</a>
 * <p>有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 * <p>
 * <p>返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 * <p>
 * <p>注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 * <p>
 * <p>示例 1：
 * <p>输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * <p>输出：3
 * <p>解释：城市分布图如上。
 * <p>每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * <p>城市 0 -> [城市 1, 城市 2]
 * <p>城市 1 -> [城市 0, 城市 2, 城市 3]
 * <p>城市 2 -> [城市 0, 城市 1, 城市 3]
 * <p>城市 3 -> [城市 1, 城市 2]
 * <p>城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 * <p>
 * <p>示例 2：
 * <p>输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * <p>输出：0
 * <p>解释：城市分布图如上。
 * <p>每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 * <p>城市 0 -> [城市 1]
 * <p>城市 2 -> [城市 3, 城市 4]
 * <p>城市 2 -> [城市 3, 城市 4]
 * <p>城市 1 -> [城市 0, 城市 4]
 * <p>城市 3 -> [城市 2, 城市 4]
 * <p>城市 4 -> [城市 1, 城市 2, 城市 3]
 * <p>城市 0 在阈值距离 2 以内只有 1 个邻居城市。
 * <p>
 * <p>
 * <p>提示：
 * <p>
 * <p>2 <= n <= 100
 * <p>1 <= edges.length <= n * (n - 1) / 2
 * <p>edges[i].length == 3
 * <p>0 <= fromi < toi < n
 * <p>1 <= weighti, distanceThreshold <= 10^4
 * <p>所有 (fromi, toi) 都是不同的。
 * @Date Create in 2023/11/14 22:22
 */
public class FindTheCity {
    public static void main(String[] args) {
        int n = 4;
        int [][]edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        //int result = method(n, edges, distanceThreshold);
       // System.out.println("结果 = " + result);

        int n2 = 5;
        int [][]edges2 = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold2 = 2;
        //int result2 = method(n2, edges2, distanceThreshold2);

       // System.out.println("结果 = " + result2);

        int n3 = 6;
        int [][]edges3 = {{0,3,5},{2,3,7},{0,5,2},{0,2,5},{1,2,6},{1,4,7},{3,4,4},{2,5,5},{1,5,8}};
        int distanceThreshold3 = 8279;
        //int result3 = method(n3, edges3, distanceThreshold3);

        int n4 = 6;
        int [][]edges4 = {{0,3,7},{2,4,1},{0,1,5},{2,3,10},{1,3,6},{1,2,1}};
        int distanceThreshold4 = 417;
        int result4 = method(n4, edges4, distanceThreshold4);

        System.out.println("结果 = " + result4);

    }

    public static int method(int n, int[][] edges, int distanceThreshold) {
        int [][]distances = new int[n][n];

        //坐标距离初始化
        for (int i = 0; i < n; i++) {
            //默认两点间的距离是 MAX，相同两点间的距离是0
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[i][i] = 0;
        }

        //坐标数据填充
        for (int i = 0 ; i < edges.length ; i ++) {
            distances[edges[i][0]][edges[i][1]] = edges[i][2];
            distances[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        //floyd算法
        //以某个坐标作为连接中间点，根据贪心算法，不同刷新任意两点之间的距离。
        for (int i = 0; i < n; i++) {
            //拿到 从 i ->a 和 i ->b 的距离，然后更新a->b的最短距离
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {

                    //防止越界
                    if (distances[i][a] == Integer.MAX_VALUE || distances[i][b] == Integer.MAX_VALUE) {
                        continue;
                    }

                    //求最短距离

                    int distance = Integer.min(distances[i][a] + distances[i][b], distances[a][b]);
                    distances[a][b] = distance;
                    distances[b][a] = distance;
                }
            }
        }


        //拿到任意两点之间的最短距离后，就可以遍历每个点确定最终结果了。
        int minCount = n - 1;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {continue;}
                if (distances[i][j] <= distanceThreshold) {
                    System.out.println("从 "+ i +" 到 "+ j +" 的距离是 "+ distances[i][j] +" < " + distanceThreshold);
                    count ++;
                }
            }
            if (count > 0 && count <= minCount) {
                minCount = count;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static int method2(int n, int[][] edges, int distanceThreshold){
        int[][] g = new int[n][n];
        // 初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = i == j ? 0 : 0x3f3f3f3f;
            }
        }
        // 存图
        for (int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        int ans = -1, cnt = n + 10;
        for (int i = 0; i < n; i++) {
            // 单源最短路
            int[] dist = dijkstra(g, i);
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] <= distanceThreshold) {
                    System.out.println("从 "+ i +" 到 "+ j +" 的距离是 "+ dist[j] +" < " + distanceThreshold);
                    cur++;
                }
            }
            if (cur <= cnt) {
                cnt = cur; ans = i;
            }
        }
        return ans;

    }

    static int[] dijkstra(int[][] g, int x) {
        int n = g.length;
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, 0x3f3f3f3f);
        // 只有起点最短距离为 0
        dist[x] = 0;
        // 有多少个点就迭代多少次
        for (int k = 0; k < n; k++) {
            // 每次找到「最短距离最小」且「未被更新」的点 t
            int t = -1;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && (t == -1 || dist[i] < dist[t])) t = i;
            }
            // 标记点 t 为已更新
            vis[t] = true;
            // 用点 t 的「最小距离」更新其他点
            for (int i = 0; i < n; i++) dist[i] = Math.min(dist[i], dist[t] + g[t][i]);
        }
        return dist;
    }
}
