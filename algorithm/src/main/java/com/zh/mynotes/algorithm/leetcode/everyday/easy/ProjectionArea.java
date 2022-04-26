package com.zh.mynotes.algorithm.leetcode.everyday.easy;

/**
 * @Author zeng hao
 * @Description 883. 三维形体投影面积
 * 在n x n的网格grid中，我们放置了一些与 x，y，z 三轴对齐的1 x 1 x 1立方体。
 *
 * 每个值v = grid[i][j]表示 v个正方体叠放在单元格(i, j)上。
 *
 * 现在，我们查看这些立方体在 xy、yz和 zx平面上的投影。
 *
 * 投影就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回 所有三个投影的总面积 。
 *
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * 示例2:
 *
 * 输入：grid = [[2]]
 * 输出：5
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：8
 * 
 *
 * 提示：
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/projection-area-of-3d-shapes">https://leetcode-cn.com/problems/projection-area-of-3d-shapes</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/26 13:05
 */
public class ProjectionArea {

    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,2}};
        System.out.println(method(grid));
    }

    //俯视图 数组元素个数（不包含v=0）
    //正视图 同一行最大值相加
    //侧视图 同一列最大值相加
    public static int method(int[][] grid) {
        int sum = 0;
        int[] colum = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                int v = grid[i][j];
                if (max < v){
                    max = v;
                }
                if (colum[j] < v){
                    colum[j] = v;
                }
                if (i == grid.length - 1){
                    sum += colum[j];
                }
                if (v != 0){
                    sum ++;
                }
            }
            sum += max;
        }
        return sum;
    }
}
