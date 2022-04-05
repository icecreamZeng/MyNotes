package com.zh.mynotes.algorithm.leetcode.everyday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zeng hao
 * @Description 762. 二进制表示中质数个计算置位
 * 给你两个整数left和right ，在闭区间 [left, right]范围内，统计并返回 计算置位位数为质数 的整数个数。
 *
 * 计算置位位数 就是二进制表示中 1 的个数。
 *
 * 例如， 21的二进制表示10101有 3 个计算置位。
 * 
 *
 * 示例 1：
 *
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * 示例 2：
 *
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 * 
 *
 * 提示：
 *
 * 1 <= left <= right <= 106
 * 0 <= right - left <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/05 19:22
 */
public class CountPrimeSetBits {
    public static void main(String[] args) {
        System.out.println(method(10,15));
    }

    public static int method(int left, int right) {
        Set<Integer> set = new HashSet<>();
        int n = 1;
        while (Math.pow(2, n) - 1 <= right){
            n++;
            isPrime(set, n);
        }
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(Integer.bitCount(i))){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(Set<Integer> set, int number){
        if (set.contains(number)){
            return true;
        }
        if (number <= 3){
            set.add(number);
            return true;
        }
        if (number % 2 == 0){
            return false;
        }
        int k = (int)Math.sqrt(number);
        for (int i = 2; i <= k; i++) {
            if (number % i ==0){
              return false;
            }
        }
        set.add(number);
        return true;
    }
}
