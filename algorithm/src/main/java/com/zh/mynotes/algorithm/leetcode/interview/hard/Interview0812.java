package com.zh.mynotes.algorithm.leetcode.interview.hard;

import java.util.*;

/**
 * @Author zeng hao
 * @Description 面试题 08.12. 八皇后
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 *
 *  实例：

 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..", // 解法 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 * ["..Q.", // 解法 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 * @Date Create in 2021/11/2 16:14
 */

public class Interview0812 {

    static List<List<String>> res = new ArrayList<>();
    static Set<Integer> choose1 = new HashSet<>();
    static Set<Integer> choose2 = new HashSet<>();
    static Set<Integer> choose3 = new HashSet<>();
    static String initStr;
    public static void main(String[] args) {
        solveNQueens(4);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("第种"+ i +"情况");
            System.out.println(res.get(i));
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        initStr = initStr(n);
        List<String> path = init(n);
        method(path, 0);
        return res;
    }

    private static String initStr(int n) {
        return String.join("", Collections.nCopies(n,"."));
    }

    private static void method(List<String> path, int row) {
        int n = path.size();
        if (n <= row){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid2(path, row, col)){
                continue;
            }
            choose1.add(col);
            choose2.add(row + col);
            choose3.add(row - col);
            String choose = initStr(col) + "Q" + initStr(n - col - 1);
            path.set(row, choose);
            method(path, row + 1);
            choose1.remove(col);
            choose2.remove(row + col);
            choose3.remove(row - col);
            path.set(row, initStr);
        }
    }

    /**
     * 很奇怪，减少了路径判断，leetcode反而慢了
     * @param path
     * @param row
     * @param col
     * @return
     */
    private static boolean isValid2(List<String> path, int row, int col) {
        if (choose1.contains(col)){
            return false;
        }

        if (choose2.contains(row + col)){
            return false;
        }
        if (choose3.contains(row - col)){
            return false;
        }
        return true;
    }

    /**
     * 这里判断落子太多复杂了，可以简化下
     * @param path
     * @param row
     * @param col
     * @return
     */
    private static boolean isValid(List<String> path, int row, int col) {
        int n = path.size();
        for (int i = 0; i < row; i++) {
            if (path.get(i).charAt(col) == 'Q'){
                return false;
            }

            if ((i + col - row) >= 0 && (i + col - row) < n && path.get(i).charAt(i + col - row) == 'Q'){
                return  false;
            }

            if ((row + col - i) >= 0 && (row + col - i) < n && path.get(i).charAt(row + col - i) == 'Q'){
                return false;
            }
        }
        return true;
    }
    

    private static List<String> init(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(initStr);
        }
        return list;
    }


}
