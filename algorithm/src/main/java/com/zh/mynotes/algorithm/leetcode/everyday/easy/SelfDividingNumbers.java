package com.zh.mynotes.algorithm.leetcode.everyday.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zeng hao
 * @Description 728. 自除数
 * 自除数是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数left和right ，返回一个列表，列表的元素是范围[left, right]内所有的 自除数 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 示例 2:
 *
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/03/31 15:22
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(method(1, 1000));
    }

    public static List<Integer> method(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (check(i)){
                result.add(i);
            }
        }
        return result;
    }

    private static boolean check(int num) {
        int temp = num;
        int x = temp % 10;
        while (x != 0 && temp != 0){
            if (num % x != 0){
                return false;
            }
            temp = temp / 10;
            if (temp == 0){
                break;
            }
            x = temp % 10;
        }
        return x != 0;
    }
}
