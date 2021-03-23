package code.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: BG382769
 * @Description:
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 * @Date: Created in 2021/3/23 16:38
 */
public class CodingInterviews03 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums){
            if (set.contains(num)){
                return num;
            }else  {
                set.add(num);
            }
        }
        return -1;
    }


    public static int findRepeatNumber2(int[] nums){
        int[] numArray = new int[100000];
        for (int num : nums){
            if (numArray[num] > 0){
                return num;
            }else {
                numArray[num] = 1;
            }
        }
        return -1;
    }

    //在前面的基础上可以减少自定义数组的初始大小，减少浪费。
    //因为题目说明是 数组长度为n ，元素大小 在 0~n-1之间，感觉还是有取巧的意思。
    public static int findRepeatNumber3(int[] nums){
        int[] numArray = new int[nums.length];
        for (int num : nums){
            if (numArray[num] > 0){
                return num;
            }else {
                numArray[num] = 1;
            }
        }
        return -1;
    }
}
