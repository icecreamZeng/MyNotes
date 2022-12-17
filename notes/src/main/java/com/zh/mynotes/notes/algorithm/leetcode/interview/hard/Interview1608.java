package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

/**
 *
 * @Author zeng hao
 * @Description 面试题 16.08. 整数的英语表示
 * 给定一个整数，打印该整数的英文描述。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 示例 2:
 *
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 示例 3:
 *
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4:
 *
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * 注意：本题与273 题相同：https://leetcode-cn.com/problems/integer-to-english-words/
 * @Date Create in 2021/11/5 23:46
 */
public class Interview1608 {
    
    public static void main(String[] args) {
        System.out.println(numberToWords(1000000));
    }

    //思考下人类是怎么读数字的？
    //也是先数有多少位
    //integer最大能表示
    public static String numberToWords(int num) {
        StringBuilder res = new StringBuilder();
        if (num == 0){
            return "Zero";
        }
        if (num < 0){
            res.append("Minus ");
        }
        String numStr = String.valueOf(Math.abs(num));
        int length = numStr.length();
        int startIndex = 0;
        int endIndex = length % 3;
        if (endIndex ==0){
            endIndex = 3;
        }
        while (length > 0){
            String str = numStr.substring(startIndex, endIndex);
            length -= str.length();
            res.append(translate(str, length + 1));
            startIndex = endIndex ;
            endIndex += 3;
        }
        return res.toString().trim();
    }

    private static String printUnit(int length){
        switch (length){
            case 3: return "Hundred ";
            case 4: return "Thousand ";
            case 7: return "Million ";
            case 10: return "Billion ";
            default: return "";
        }
    }

    private static String translateNum(char ch, boolean flag){
        switch (ch){
            case '1': return flag ? "One " : "Eleven ";
            case '2': return flag ? "Two " : "Twelve ";
            case '3': return flag ? "Three " : "Thirteen ";
            case '4': return flag ? "Four " : "Fourteen ";
            case '5': return flag ? "Five " : "Fifteen ";
            case '6': return flag ? "Six " : "Sixteen ";
            case '7': return flag ? "Seven " : "Seventeen ";
            case '8': return flag ? "Eight " : "Eighteen ";
            case '9': return flag ? "Nine " : "Nineteen ";
            default: return flag ? "" : "Ten ";
        }
    }
    private static String translateDecade(char ch){
        switch (ch){
            case '2' : return "Twenty ";
            case '3' : return "Thirty ";
            case '4' : return "Forty ";
            case '5' : return "Fifty ";
            case '6' : return "Sixty ";
            case '7' : return "Seventy ";
            case '8': return "Eighty ";
            case '9' : return "Ninety ";
            default: return "";
        }
    }

    private static String translate(String numStr, int length){
        int num = Integer.parseInt(numStr);
        StringBuilder res = new StringBuilder();
        if (num > 99){
            res.append(translateNum(numStr.charAt(0), true)).append(printUnit(3));
        }
        int num2 = num % 100;
        if (num2 < 20){
            int num3 = num2 % 10;
            res.append(translateNum(String.valueOf(num3).charAt(0), num2 < 10));
        } else {
            res.append(translateDecade(String.valueOf(num2).charAt(0)));
            res.append(translateNum(String.valueOf(num2).charAt(1), true));
        }
        if (num != 0){
            res.append(printUnit(length));
        }
        return res.toString();
    }

}
