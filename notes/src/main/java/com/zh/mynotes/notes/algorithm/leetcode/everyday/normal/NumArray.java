package com.zh.mynotes.notes.algorithm.leetcode.everyday.normal;

/**
 * @Author zeng hao
 * @Description 307. 区域和检索 - 数组可修改
 * 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组nums下标对应的值
 * 另一类查询要求返回数组nums中索引left和索引right之间（包含）的nums元素的 和，其中left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组nums中索引left和索引right之间（包含）的nums元素的 和（即，nums[left] + nums[left + 1], ..., nums[right]）
 * 
 *
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 *
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 *104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 调用 update 和 sumRange 方法次数不大于3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/04 16:59
 */
public class NumArray {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray numArray = new NumArray(nums);
        //System.out.println(numArray.sumRange(0,2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(35,12456));
    }

    private int[] arr;

    private int[] sum10;
    private int[] sum100;
    private int[] sum1000;
    public NumArray(int[] nums) {
        arr = nums;
        int length = arr.length;
        int size10 = length / 10 + (length % 10 == 0 ? 0 : 1);
        int size100 = length / 100 + (length % 100 == 0 ? 0 : 1);
        int size1000 = length / 1000 + (length % 1000 == 0 ? 0 : 1);
        sum10 = new int[size10 == 0 ? 1 : size10];
        sum100 = new int[size100 == 0 ? 1 : size100];
        sum1000 = new int[size1000 == 0 ? 1 : size1000];
        for (int i = 0; i < length; i++) {
            sum10[getRange(i, 10)] += nums[i];
            sum100[getRange(i, 100)] += nums[i];
            sum1000[getRange(i, 1000)] += nums[i];
        }
    }

    public void update(int index, int val) {
        int change = val - arr[index];
        arr[index] = val;
        sum10[getRange(index, 10)] += change;
        sum100[getRange(index, 100)] += change;
        sum1000[getRange(index, 1000)] += change;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        int index = left;
        while ((index + 1) % 10 != 0){
            if (index + 1 > right){
                break;
            }
            sum += arr[++index];
        }
        while ((index + 1) % 100 != 0){
            if (index + 10 > right){
                break;
            }
            index += 10;
            sum += sum10[getRange(index, 10)];
        }
        while ((index + 1) % 1000 != 0){
            if (index + 100 > right){
                break;
            }
            index += 100;
            sum += sum100[getRange(index, 100)];
        }
        while (index <= right){
            if (index + 1000 <= right){
                index += 1000;
                sum += sum1000[getRange(index, 1000)];
                continue;
            }
            if (index + 100 <= right){
                index += 100;
                sum += sum100[getRange(index, 100)];
                continue;
            }
            if (index + 10 <= right){
                index += 10;
                sum += sum10[getRange(index, 10)];
                continue;
            }
            if (index + 1 <= right){
                sum += arr[++index];
            }
            break;
        }

        return sum;
    }

    private int getRange(int index, int range){
        return (index + 1) / range + ((index + 1) % range == 0 ? -1 : 0);
    }


    //竟然可以用线段树
    int[] tree;
    int n ;
    void init(int[] nums){
        n = nums.length;
        tree = new int[n * 2];
        for (int i = 0; i < n; i++) {
            tree[i + n] = nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
    void update1(int index, int val){
        index += n;
        tree[index] = val;
        int left = index;
        int right = index;
        while (index > 0){
            if (index % 2 == 0){
                left = index;
                right = index + 1;
                index = index / 2;
            }else{
                left = index -1;
                right = index;
                index = (index -1)/2;
            }
            tree[index] = tree[left] + tree[right];
        }
    }

    int get(int left , int right){
        int sum = 0;
        while (left <= right){
            if (left % 2 == 1){
                sum += tree[++left];
            }
            if (right % 2 == 0){
                sum += tree[-- right];
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

}
