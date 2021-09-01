package com.zh.mynotes.algorithm.leetcode.codinginterview.easy;

/**
 * @Author: Zeng Hao
 * @Description:
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @Date: Created in 2021/5/19 20:13
 */
public class CodingInterviews05 {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
        System.out.println(replaceSpace2("We are happy."));
        System.out.println(replaceSpace3("We are happy."));
    }


    /*
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * 0 <= s 的长度 <= 10000
     */
    public static String replaceSpace(String s) {
        if (s == null){
            return null;
        }
        char [] newChars = new char[s.length() * 3];
        int index = 0;
        char ch ;
        for (int i =0 ; i < s.length() ; i++){
            ch = s.charAt(i);
            if (ch == ' '){
                newChars[index] = '%';
                newChars[index + 1] = '2';
                newChars[index + 2] = '0';
                index += 3;
            }else   {
                newChars[index ++] = ch;
            }
        }
        return String.copyValueOf(newChars, 0, index);
    }

    /**
     * 采用 java  string类 自带的方法
     * 底层实际是正则表达式
     * TODO 正则究竟是如何工作的？
     * @param s
     * @return
     */
    public static String replaceSpace2(String s){
        if (s == null){
            return null;
        }
        return s.replace(" ", "%20");
    }

    /**
     * 使用 stringbuilder 工具类
     * TODO stringBuilder stringBuffer 底层如何工作的？
     * @param s
     * @return
     */
    public static String replaceSpace3(String s){
        if (s == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char ch ;
        for (int i =0 ; i < s.length() ; i++){
            ch = s.charAt(i);
            if (ch == ' '){
                sb.append("%20");
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
