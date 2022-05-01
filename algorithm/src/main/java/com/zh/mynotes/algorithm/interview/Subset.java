package com.zh.mynotes.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zeng hao
 * @Description 求集合子集
 * 20220426字节一面
 * 示例1：
 * 输入 [1,2,3]
 * 输出[[],[1],[1,2],[1,2,3],[2],[2,3],[3],[1,3]]
 * @Date Create in 2022/04/27 19:32
 */
public class Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(method(nums));
    }

    public static List<List<Integer>> method(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n = (int) Math.pow(2, nums.length);
        for (int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            int idx = i;
            for (int j = 0; j < nums.length && idx > 0; j++) {
                if (idx % 2 == 1){
                    list.add(nums[j]);
                }
                idx = idx >> 1;
            }
            res.add(list);
        }
        return res;
    }
}
