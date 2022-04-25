package com.zh.mynotes.algorithm.leetcode.everyday.normal;

import java.util.*;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2022/04/25 12:38
 */
public class NumIdx {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3};
        NumIdx idx = new NumIdx(nums);
        System.out.println(idx.pick(3));
    }

    Map<Integer, List<Integer>> map ;
    Random random;
    public NumIdx(int[] nums){
        map = new HashMap<>();
        random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            List<Integer> list = map.computeIfAbsent(num, k -> new ArrayList<>());
            list.add(i);
        }
    }

    public int pick(int target){
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }


    int[] nums;


    public int pick2(int target){
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                count ++;
                if (random.nextInt(count) == 0){
                    res = i;
                }
            }
        }
        return res;
    }
}
