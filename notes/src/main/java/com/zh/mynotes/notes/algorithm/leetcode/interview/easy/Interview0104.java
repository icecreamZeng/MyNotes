package com.zh.mynotes.notes.algorithm.leetcode.interview.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）

 * @Date: Created in 2021/1/6 10:41
 */
public class Interview0104 {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome2("aaaabbbbbccccc"));

    }

    public static boolean canPermutePalindrome2(String s){
        count(s);
        char[] chars = s.toCharArray();int sL = chars.length;
        int length = sL / 2 + sL % 2;
        int index = 0;
        for (char ch : chars){

        }
        return true;
    }

    public static boolean canPermutePalindrome1(String s) {
        count(s);
        char[] chars = s.toCharArray();
        int sL = chars.length;
        int length = sL / 2 + sL % 2;
        int count = 0;
        for (int i = 0; i < length ;i ++){
            char ch = chars[i];
            int index = method(chars, i+1, sL - i - 1, ch);
            if (index < 0){
                boolean b = sL > 2 * i + 1;
                if (++ count  > 1 && b){
                    return false;
                }
                char tmp = chars[length -1];
                chars[i] = tmp;
                chars[length - 1] = ch;
                ch = tmp;
                index = method(chars, i+1, sL - i - 1, ch);
                if (index < 0){
                    return !b;
                }
            }
            if (index != sL - i -1){
                char tmp = chars[sL - i- 1];
                chars[sL - i- 1] = ch;
                chars[index] = tmp;
            }
        }
        return true;
    }

    private static void count(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(16);
        for (char ch : chars){
            int count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);
        }
        map.forEach((key, count) -> {
            System.out.println("char = " + key + ":"+ count);
        });
    }

    private static int method(char[] chars, int fromIndex, int toIndex, char ch) {
        for (;fromIndex <= toIndex; fromIndex ++){
            if (chars[fromIndex] == ch){
                return fromIndex;
            }
        }
        return -1;
    }
}
