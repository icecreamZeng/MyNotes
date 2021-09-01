package com.zh.mynotes.algorithm.leetcode.codinginterview.normal;

/**
 * @Author: Zeng Hao
 * @Description:
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
给定 target=5，返回true。

给定target=20，返回false。

限制：

0 <= n <= 1000

0 <= m <= 1000

注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * @Date: Created in 2021/3/23 17:09
 */
public class CodingInterviews04 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,   4,  7, 11, 15},
                                     {2,   5,  8, 12, 19},
                                     {3,   6,  9, 16, 22},
                                     {10, 13, 14, 17, 24},
                                     {18, 21, 23, 26, 30}};
        int[][] intnums = new int[][]{{-5}};
        System.out.println(findNumberIn2DArray(intnums, 19));
    }

    /**
     * 第一想法是，在遍历数组之前尽量减小查找的范围
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row <= 0){
            return false;
        }
        int column = matrix[0].length;
        if (column <= 0){
            return false;
        }
        for (int i = 0 ; i < matrix[0].length; i++){
            if (matrix[0][i] == target){
                return true;
            }
            if (matrix[0][i] < target){
                column = i;
                //System.out.println("column = " + column);
            }else {
                break;
            }
        }
        for (int i = 0 ; i < matrix.length ; i ++){
            if (matrix[i][0] == target){
                return true;
            }
            if (matrix[i][0] < target){
                row = i;
                //System.out.println("row = " + row);
            }else {
                break;
            }
        }
        for (int i = 0 ; i <= row && i < matrix.length ; i++){
            for (int j = 0 ; j <= column && j < matrix[0].length ; j++){
                //System.out.println("matrix["+i+"]["+j+"] =="+matrix[i][j]);
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    //
}
