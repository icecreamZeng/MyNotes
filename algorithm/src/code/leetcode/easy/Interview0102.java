package code.leetcode.easy;

import java.util.Map;

/**
 * @Author: BG382769
 * @Description: 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100

 * @Date: Created in 2021/1/6 0:30
 */
public class Interview0102 {
    public static void main(String[] args) {
        System.out.println(CheckPermutation3("null", "nlul"));
    }
    public static boolean CheckPermutation3(String s1, String s2){
        if (s1 == s2){
            return true;
        }
        int length1 = s1 == null ? 0 : s1.length();
        int length2 = s2 == null ? 0 : s2.length();
        if (length1 != length2){
            return false;
        }
        char[] chars = s2.toCharArray();
        for (int i = 0 ;  i < s1.length() ; i++){
            char ch = s1.charAt(i);
            for (int j = i ; j < s2.length() ; j ++ ){
                if (chars[j] == ch){
                    char tmp = chars[i];
                    chars[i] = ch;
                    chars[j] = tmp;
                    break;
                }else if (j + 1 >= s2.length()){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean CheckPermutation2(String s1, String s2){
        if (s1 == s2){
            return true;
        }
        int length1 = s1 == null ? 0 : s1.length();
        int length2 = s2 == null ? 0 : s2.length();
        if (length1 != length2){
            return false;
        }

        java.util.Map<Character, Integer> charCount = new java.util.HashMap<>(100);
        for (int i=0 ; i < s1.length() ; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            int count1 = charCount.getOrDefault(ch1, 0);
            charCount.put(ch1, ++count1);
            int count2 = charCount.getOrDefault(ch2, 0);
            charCount.put(ch2, --count2);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()){
            if (entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 这是迫不得已的方法，不推荐
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation1(String s1, String s2) {
        if (s1 == s2){
            return true;
        }
        int length1 = s1 == null ? 0 : s1.length();
        int length2 = s2 == null ? 0 : s2.length();
        if (length1 != length2){
            return false;
        }
        java.util.Map<Character, Integer> charCount1 = new java.util.HashMap<>(100);
        java.util.Map<Character, Integer> charCount2 = new java.util.HashMap<>(100);
        for (int i=0 ; i < s1.length() ; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            int count1 = charCount1.getOrDefault(ch1, 0);
            charCount1.put(ch1, ++count1);
            int count2 = charCount2.getOrDefault(ch2, 0);
            charCount2.put(ch2, ++count2);
        }
        for (Map.Entry<Character, Integer> entry : charCount1.entrySet()){
            if (entry.getValue() != charCount2.getOrDefault(entry.getKey(), 0)){
                return false;
            }
        }
        return true;
    }
}
