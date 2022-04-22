package com.zh.mynotes.algorithm.leetcode.everyday.normal;

/**
 * @Author zeng hao
 * @Description 396. 旋转函数
 * 给定一个长度为 n 的整数数组nums。
 *
 * 假设arrk是数组nums顺时针旋转 k 个位置后的数组，我们定义nums的 旋转函数F为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回F(0), F(1), ..., F(n-1)中的最大值。
 *
 * 生成的测试用例让答案符合32 位 整数。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * 示例 2:
 *
 * 输入: nums = [100]
 * 输出: 0
 * 
 *
 * 提示:
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * -100 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/rotate-function">https://leetcode-cn.com/problems/rotate-function</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/22 15:35
 */
public class MaxRotateFunction {
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        System.out.println(method(nums));
    }

    public static int method(int[] nums) {
        int n = nums.length;
        int res = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            res += j * nums[j];
        }
        int max = res;
        for (int i = 1; i < n; i++) {
            res  += sum - n * nums[n - i];
            if (max < res){
                max = res;
            }
        }
        return max;
    }
}
