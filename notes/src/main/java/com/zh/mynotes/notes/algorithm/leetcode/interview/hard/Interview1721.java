package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

/**
 * @Author zeng hao
 * @Description 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @Date Create in 2021/11/08 2:56
 */
public class Interview1721 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{5,6,8,0,8,0,1,0,6,8,6}));
    }
    public static int trap(int[] height) {
        return method(height, height.length - 1, 0);
    }

    private static int method(int[] height, int leftIndex, int rightIndex) {
        if (leftIndex <=0 && rightIndex >= height.length - 1){
            return 0;
        }
        int leftA = 0;
        int leftB = 0;
        int rightA = height.length - 1;
        int rightB = height.length - 1;
        for (int i = 0 ; i < height.length; i++) {
            int leftHi = height[i];
            int rightHi = height[height.length - i - 1];
            if (leftHi >= height[leftB] && i <= leftIndex){
                leftA = leftB;
                leftB = i;
            }
            if (leftB >= rightA){
                break;
            }
            if (rightHi >= height[rightA] && height.length - i - 1 >= rightIndex){
                rightB = rightA;
                rightA = height.length - i - 1;
            }
            if (leftB >= rightA){
                break;
            }
        }
        int area = 0;
        if (leftB == rightB && leftA == rightA){
            area += getArea(height, leftA, rightB);
        }else {
            area += getArea(height, leftA, leftB);
            area += getArea(height, rightA, rightB);
        }
        return area + method(height, leftA, rightB);
    }

    private static int getArea(int[] height, int left, int right) {
        int area = 0;
        if (right - left < 1){
            return area;
        }
        area += Math.min(height[left], height[right]) * (right - left - 1);
        for (int i = left + 1; i < right; i++) {
            area -= height[i];
        }
        return area;
    }
}
