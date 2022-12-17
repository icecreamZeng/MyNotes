package com.zh.mynotes.notes.algorithm.leetcode.everyday.easy;

/**
 * @Author zeng hao
 * @Description 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 * 
 *
 * 示例 1：
 *
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 示例 2:
 *
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 示例 3:
 *
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 * 
 *
 * 提示：
 *
 * 2 <= letters.length <= 104
 * letters[i]是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/03 20:05
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] letters = {'a', 'b'};
        char target = 'z';
        System.out.println(method(letters, target));
    }


    public static char method(char[] letters, char target) {
        for (int i = 0; i <letters.length; i++) {
            char ch = letters[i];
            if (ch > target){
                return ch;
            }
        }
        return letters[0];
    }
}
