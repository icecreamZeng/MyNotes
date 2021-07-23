package code.leetcode.interview.normal;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 01.08. 零矩阵
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * @Date: Created in 2021/7/20 17:14
 */
public class Interview0108 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrix2 = new int[m][n];
        int count = 0;
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0; j < n; j++) {
                int item = matrix[i][j];
                if (item == 0){
                    matrix2[i][j] = 1;
                    count ++;
                }
            }
        }
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0; j < n; j++) {
                if (count <= 0){
                    break;
                }
                int item = matrix2[i][j];
                if (item == 1){
                    count --;
                    for (int x = 0 ; x < m ; x ++){
                        matrix[x][j] = 0;
                    }
                    for (int y = 0 ; y < n ; y ++){
                        matrix[i][y] = 0;
                    }
                }
            }
        }
    }
}
