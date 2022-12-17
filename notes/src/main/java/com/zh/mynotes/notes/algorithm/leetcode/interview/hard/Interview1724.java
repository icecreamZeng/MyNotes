package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zeng hao
 * @Description 面试题 17.24. 最大子矩阵
 * 给定一个正整数、负整数和 0 组成的 N × M矩阵，编写代码找出元素总和最大的子矩阵。
 *
 * 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
 *
 * 注意：本题相对书上原题稍作改动
 * 示例：
 *
 * 输入：
 * [
 *   [-1,0],
 *   [0,-1]
 * ]
 * 输出：[0,1,0,1]
 * 解释：输入中标粗的元素即为输出所表示的矩阵
 * 
 *
 * 说明：
 *
 * 1 <= matrix.length, matrix[0].length <= 200
 * @Date Create in 2021/11/08 13:25
 */
public class Interview1724 {

    static Map<String, Integer> areaMap = new HashMap<>();

    public static void main(String[] args) {

    }

    //巧妙的将二维问题化解为一维问题
    public int[] getMaxMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[] coordinates = new int[4];
        int tempI = 0;
        int tempJ = 0;
        for (int i = 0; i < n; i++) {
            int[] area = new int[m];
            for (int j = i; j < n; j++) {
                //初始化
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    area[k] += matrix[j][k];
                    if (sum > 0){
                        sum += area[k];
                    }else {
                        sum = area[k];
                        tempI = i;
                        tempJ = k;
                    }
                    if (sum > max){
                        max = sum;
                        coordinates[0] = tempI;
                        coordinates[1] = tempJ;
                        coordinates[2] = j;
                        coordinates[3] = k;
                    }
                }
            }
        }
        return coordinates;
    }
}
