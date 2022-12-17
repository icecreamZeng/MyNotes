package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

/**
 * @Author zeng hao
 * @Description 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 * 示例 1:
 * 输入: [1]
 * 输出: [2,3]
 *
 * 示例 2:
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 *
 * nums.length <= 30000
 * @Date Create in 2021/11/08 1:17
 */
public class Interview1719 {

    public static void main(String[] args) {
        int [] res = missingTwo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100});
        System.out.println("{"+ res[0] +","+ res[1] +"}");
    }

    public static int[] missingTwo(int[] nums) {
        long sum = 0;
        int length = nums.length;
        int [] arr = new int[length + 2];
        for (int i = 0; i < length; i++) {
            arr[nums[i] - 1] = 1;
            sum += i + 1;
            sum -= nums[i];
        }
        sum += length + 1;
        sum += length + 2;
        for (int i = 1; i <= length + 2; i++) {
            if (arr[i - 1] == 0){
                return new int[]{i, (int)(sum - i)};
            }
        }
        return new int[]{1, length + 2};
    }
}
