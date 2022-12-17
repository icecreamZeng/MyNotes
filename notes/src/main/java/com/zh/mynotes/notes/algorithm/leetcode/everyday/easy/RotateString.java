package com.zh.mynotes.notes.algorithm.leetcode.everyday.easy;

/**
 * @Author zeng hao
 * @Description 796. 旋转字符串
 * 给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，那么返回true。
 *
 * s的 旋转操作 就是将s 最左边的字符移动到最右边。
 *
 * 例如, 若s = 'abcde'，在旋转一次之后结果就是'bcdea'。
 * 
 *
 * 示例 1:
 *
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * 
 *
 * 提示:
 *
 * 1 <= s.length, goal.length <= 100
 * s和goal由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/07 11:06
 */
public class RotateString {
    public static void main(String[] args) {
        System.out.println(method("abcde","bcdea"));
    }

    public static boolean method(String s, String goal) {
        if (s == null || goal == null || s.length() != goal.length()){
            return false;
        }
        String str = s + s;
        return str.contains(goal);
    }
}
