package com.zh.mynotes.notes.algorithm.leetcode.algorithms;

import java.util.*;

/**
 * @Author zeng hao
 * @Description topk问题
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * https://leetcode-cn.com/problems/top-k-frequent-elements
 * https://leetcode-cn.com/circle/article/5GF572/
 * @Date Create in 2021/11/16 5:37
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = {5,1,-1,-8,-7,8,-5,0,1,10,8,0,-4,3,-1,-1,4,-5,4,-3,0,2,2,2,4,-2,-4,8,-7,-7,2,-8,0,-8,10,8,-8,-2,-9,4,-7,6,6,-1,4,2,8,-3,5,-9,-3,6,-8,-5,5,10,2,-5,-1,-5,1,-3,7,0,8,-2,-3,-1,-5,4,7,-9,0,2,10,4,4,-4,-1,-1,6,-8,-9,-1,9,-9,3,5,1,6,-1,-2,4,2,4,-6,4,4,5,-5
        };
        int k = 7;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }

    /* 前k高频的元素，返回的元素个数一定是k个？ 有可能有些元素的频次相同
    * 初步想法：准备两个同样大小的数组，一个按照频次放元素，一个放相应位置元素的频次
    * 由于不知道到底有多少个元素并且不确定是否有重复频次的元素，数组初始化大小为输入数组大小。
    * */
    public static int[] topKFrequent1(int[] nums, int k) {
        int length = nums.length;
        int[] e = new int[length];
        int[] num = new int[length];
        int l = 0;
        for (int i = 0; i < length; i++) {
            e[i] = Integer.MAX_VALUE;
            num[i] = 0;
            int index = 0;
            while (index <= i && e[index] < Integer.MAX_VALUE){
                if (e[index] == nums[i]){
                    num[index]++;
                    break;
                }
                index ++;
            }
            if (e[index] >= Integer.MAX_VALUE){
                l = index;
                e[index] = nums[i];
                num[index]++;
            }
        }
        int r = k;
        for (int i = 1 ; i <= l ; i++) {
            for (int j = l ; j >= i ; j--){
                if (num[j] > num[j - 1]){
                    int tmp = num[j];
                    num[j] = num[j -1];
                    num[j - 1] = tmp;
                    int etmp = e[j];
                    e[j] = e[j - 1];
                    e[j - 1] = etmp;
                }
            }
            if (i >= k && num[i-1] > num[i]){
                r = i;
                break;
            }
        }
        int[] result = new int[r];
        for (int i = 0; i < r; i++) {
            result[i] = e[i];
        }
        return result;
    }

    /* 有一点是可以明确的，整个nums数组需要遍历。
    * 能不能在遍历的时候就已经排序好了？
    * */
    public static int[] topKFrequent2(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int l = map.size();
        int[] e = new int[l];
        int[] num = new int[l];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            e[index] = entry.getKey();
            num[index] = entry.getValue();
            index++;
        }
        int r = k;
        for (int i = 1 ; i < l ; i++) {
            for (int j = l - 1 ; j >= i ; j--){
                if (num[j] > num[j - 1]){
                    int tmp = num[j];
                    num[j] = num[j -1];
                    num[j - 1] = tmp;
                    int etmp = e[j];
                    e[j] = e[j - 1];
                    e[j - 1] = etmp;
                }
            }
            if (i >= k && num[i-1] > num[i]){
                r = i;
                break;
            }
        }
        int[] result = new int[r];
        for (int i = 0; i < r; i++) {
            result[i] = e[i];
        }
        return result;
    }

    public static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll()).getKey();
        }
        return result;
    }
}
