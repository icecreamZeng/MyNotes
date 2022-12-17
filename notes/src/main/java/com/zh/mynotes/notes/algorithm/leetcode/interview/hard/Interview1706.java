package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

/**
 *
 * @Author zeng hao
 * @Description 面试题 17.06. 2出现的次数
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 *
 * 示例:
 *
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 *
 * n <= 10^9
 * @Date Create in 2021/11/6 1:00
 */
public class Interview1706 {
    

    public static void main(String[] args) {
        System.out.println(numberOf2sInRange(251));
    }

    //0-9  1
    //10 - 99 19
    //100 - 999
    public static int numberOf2sInRange(int n) {
        return method(n);
    }

    private static int method(int n) {
        String numStr = String.valueOf(n);
        int length = numStr.length();
        if (length <= 1){
            return n >= 2 ? 1 : 0 ;
        }
        int sum = 0;
        int num1 = (int)Math.pow(10, length - 1);
        int calTwo = calTwo(num1 - 1);
        char ch = numStr.charAt(0);
        sum += calTwo * (ch -'0');
        if (ch == '2'){
            sum += n % num1 + 1;
        }else if (numStr.charAt(0) > '2'){
            sum += num1;
        }
        return  sum + method(n % num1);
    }

    public static int calTwo(int n){
        String numStr = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int num = 1;
            for (int j = 0; j < numStr.length(); j++) {
                if (j == i){
                    continue;
                }
                num *= numStr.charAt(j) - '0' + 1;
            }
            res += num;
        }
        return res;
    }
}
