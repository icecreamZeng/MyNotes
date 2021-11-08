package com.zh.mynotes.algorithm.leetcode.interview.hard;

/**
 * @Author zeng hao
 * @Description 面试题 17.25. 单词矩阵
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 *
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 *
 * 示例 1:
 *
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * [
 *   "this",
 *   "real",
 *   "hard"
 * ]
 * 示例 2:
 *
 * 输入: ["aa"]
 * 输出: ["aa","aa"]
 * 说明：
 *
 * words.length <= 1000
 * words[i].length <= 100
 * 数据保证单词足够随机
 * @Date Create in 2021/11/08 17:04
 */
public class Interview1725 {
    //思路
    //1.构建字典树，方便更快的过滤无效的结果
    //2.采用回溯法，从单词长度1开始，列举所有单词长度为1的可能，得到结果，计算最值
    //3.当单词列长超过所有单词长度时停止回溯
    public static void main(String[] args) {

    }


}
