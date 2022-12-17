package com.zh.mynotes.notes.algorithm.leetcode.interview.normal;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 01.07. 旋转矩阵
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @Date: Created in 2021/7/20 16:37
 */
public class Interview0107 {
    public static void main(String[] args) {
        int [][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }

    //(x, y) -> (y , N - x -1)
    //每次直接四个元素交换位置
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int count = n / 2 + n % 2;
        for (int i = 0; i < count; i ++) {
            for (int j = 0 ; j < count - n % 2 ; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
