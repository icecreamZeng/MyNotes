package com.zh.mynotes.notes.algorithm.leetcode.everyday.hard;

/**
 * @Author zeng hao
 * @Description 780. 到达终点
 * 给定四个整数sx,sy，tx和ty，如果通过一系列的转换可以从起点(sx, sy)到达终点(tx, ty)，则返回 true，否则返回false。
 *
 * 从点(x, y)可以转换到(x, x+y) 或者(x+y, y)。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: true
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * 示例 2:
 *
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: false
 * 示例 3:
 *
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: true
 * 
 *
 * 提示:
 *
 * 1 <= sx, sy, tx, ty <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reaching-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/09 0:03
 */
public class ReachingPoints {

    public static void main(String[] args) {
        System.out.println(method2(10, 4, 10, 20));
    }

    public static boolean method(int sx, int sy, int tx, int ty) {
        return dfs(sx, sy, tx, ty);
    }

    public static boolean dfs(int sx, int sy, int tx, int ty){
        if (sx > tx || sy > ty){
            return false;
        }
        if (sx == tx && sy == ty){
            return true;
        }
        if (tx > ty){
            return dfs(sx, sy, tx - ty, ty);
        }else {
            return dfs(sx, sy, tx, ty - tx);
        }
    }

    public static boolean method2(int sx, int sy, int tx, int ty){
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                break;
            } // if (tx == sx && ty == sy)

            if (tx > ty) {
                tx -= Math.max(1, (tx - sx) / ty) * ty;
            } // if (tx > ty)
            else {
                ty -= Math.max(1, (ty - sy) / tx) * tx;
            } // else
        } // while (tx > sx && ty > sy)

        return tx == sx && ty == sy;
    }
}
