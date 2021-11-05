package com.zh.mynotes.algorithm.leetcode.interview.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @Author zeng hao
 * @Description 面试题 08.13. 堆箱子
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。
 * 箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。
 * 实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 *
 * 输入使用数组[wi, di, hi]表示每个箱子。
 *
 * 示例1:

 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 *
 * 示例2:

 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * @Date Create in 2021/11/2 17:19
 */
public class Interview0813 {



    public static void main(String[] args) {
        int[][] box = new int[][]{{2, 6, 7}, {1, 1, 1}, {2, 3, 4}, {3, 4, 5}};
        int[][] box1 = new int[][]{{9, 9, 10}, {8, 10, 9}, {9, 8, 10}, {9, 8, 10}, {10, 8, 8}, {9, 8, 9}, {9, 8, 8}, {8, 9, 10}, {10, 9, 10}, {8, 8, 10}, {10, 9, 10}, {10, 9, 8}, {8, 9, 9}, {9, 10, 8}, {8, 9, 9}, {10, 10, 9}, {8, 9, 10}, {8, 10, 10}, {8, 9, 10}, {10, 10, 8}, {10, 10, 9}, {9, 10, 10}, {10, 8, 9}, {10, 10, 9}, {8, 9, 10}, {8, 8, 9}, {8, 10, 10}, {9, 9, 10}, {10, 8, 8}, {10, 10, 8}, {8, 9, 9}, {8, 9, 8}, {10, 10, 8}, {8, 10, 8}, {10, 9, 10}, {9, 9, 10}, {9, 9, 9}, {8, 9, 8}, {9, 8, 8}, {8, 9, 10}, {10, 10, 8}, {9, 9, 9}, {10, 10, 10}, {10, 9, 8}, {9, 8, 9}, {8, 8, 10}, {8, 8, 8}, {8, 8, 8}, {8, 9, 10}, {10, 9, 8}, {8, 10, 8}, {8, 10, 10}, {9, 10, 10}, {8, 8, 9}, {9, 9, 9}, {10, 8, 8}, {8, 10, 10}, {9, 10, 9}, {9, 9, 8}, {8, 10, 9}, {9, 8, 8}, {9, 9, 10}, {9, 10, 10}, {8, 8, 10}};
        int[][] box2 = new int[][]{{3, 3, 8}, {3, 6, 5}, {7, 1, 6}};
        System.out.println(pileBox(box2));
        System.out.println(pileBox2(box2));
        System.out.println(pileBox3(box2));
    }

    private static int pileBox2(int[][] box) {
        //排序后就能保证，前面的箱子一定是排在上面的。
        //后面的箱子要想被计算在内，必须对于前面每个箱子都满足必要条件
        //
        if (box == null){
            return 0;
        }
        Arrays.sort(box, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[box.length];
        dp[0] = box[0][2];
        int max = box[0][2];
        for (int i = 1; i < box.length; i++) {
            int[] temp = box[i];
            dp[i] = temp[2];
            for (int j = 0; j < i; j++) {
                int[] last = box[j];
                if (temp[0] > last[0] && temp[1] > last[1] && temp[2] > last[2]){
                    dp[i] = Math.max(temp[2] + dp[j], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int pileBox3(int[][] box) {

        Arrays.sort(box, Comparator.comparingInt(a -> a[0]));
        int [][]DP = new int[box.length][2];
        DP[0][0] = 0;
        DP[0][1] = box[0][2];
        for(int i=1 ; i<box.length ; i++){
            int []temp = box[i];
            int max = temp[2];

            for(int j = 0 ; j < i ; j++){
                int [] pre = box[j];
                if(temp[0] > pre[0] && temp[1] > pre[1] && temp[2] > pre[2]){
                    int val = temp[2] + DP[j][1];
                    if(val > max) {
                        max = val;
                    }
                }
            }



            DP[i][1] = max;
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
        }
        return Math.max(DP[box.length-1][0], DP[box.length-1][1]);
    }

    static int max = 0;
    /**
     * 理论上是可以解出来的，不过回溯法的优势在于找到所有解
     * 对于这种找最值的问题，首先可以从子问题思考，看是否满足最优子结构
     *
     * @param box
     * @return
     */
    public static int pileBox(int[][] box) {
        if (box == null || box.length == 0){
            return 0;
        }
        int heigh = 0;
        Set<Integer> hasChoose = new HashSet<>();
        method(box, hasChoose, 0, heigh, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
        return max;
    }

    private static void method(int[][] box, Set<Integer> hasChoose, int ignore, int high, int[] last) {
        if (hasChoose.size() + ignore == box.length){
            max = Math.max(high, max);
            return;
        }
        int n = box.length;
        ignore = 0;
        for (int i = 0; i < n; i++) {
            if (hasChoose.contains(i)){
                continue;
            }
            int lwi = last[0];
            int ldi = last[1];
            int lhi = last[2];
            int wi = box[i][0];
            int di = box[i][1];
            int hi = box[i][2];

            if (wi >= lwi || di >= ldi || hi >= lhi){
                ignore ++;
                continue;
            }
            hasChoose.add(i);
            method(box, hasChoose, ignore, high + hi, box[i]);
            hasChoose.remove(i);
        }
        if (hasChoose.size() + ignore == box.length){
            max = Math.max(high, max);
        }
    }
}
