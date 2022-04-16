package com.zh.mynotes.algorithm.leetcode.everyday.hard;

/**
 * @Author zeng hao
 * @Description 479. 最大回文数乘积
 * 给定一个整数 n ，返回 可表示为两个 n位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 *
 * 
 *
 * 示例 1:
 *
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * 示例 2:
 *
 * 输入： n = 1
 * 输出： 9
 * 
 *
 * 提示:
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/largest-palindrome-product">https://leetcode-cn.com/problems/largest-palindrome-product</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/16 0:02
 */
public class LargestPalindrome {
    public static void main(String[] args) {
        System.out.println(method(8));
    }

    public static int method(int n) {
        int min = (int)Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n) - 1;
        int l = max * max;
        int result = 0;
        for (int i = max; true; i --) {
            long num  = i;
            for (int x = i; x > 0 ; x /=10 ) {
                num = num * 10 + x % 10;
            }
            if (num > l){
                continue;
            }
            if (check(min, max, num, n)){
                result =  (int) num % 1337;
                break;
            }
        }
        return result;
    }

    public static boolean check(int min, int max, long num, int n){
        int sqrt = (int)Math.sqrt(num);
        for (int i = min; i <= sqrt; i++) {
            if (num % i == 0){
                long a = num / i;
                if (a >= min && a <= max){
                    return true;
                }
            }
        }
        return false;
    }
}
