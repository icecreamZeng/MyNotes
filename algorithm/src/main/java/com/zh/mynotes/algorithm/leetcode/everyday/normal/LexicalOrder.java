package com.zh.mynotes.algorithm.leetcode.everyday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zeng hao
 * @Description 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 * 
 *
 * 提示：
 *
 * 1 <= n <= 5 * 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/lexicographical-numbers">https://leetcode-cn.com/problems/lexicographical-numbers</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/18 14:43
 */
public class LexicalOrder {
    public static void main(String[] args) {
        System.out.println(method2(1000));
    }

    static List<Integer> list = new ArrayList<>();
    public static List<Integer> method(int n) {
        method(0, n);
        return list;
    }

    public static void method(int i ,int n){
        if (i > n || list.size() >= n){
            return ;
        }
        if (i > 0){
            list.add(i);
        }
        for (int j = 0; j <= 9; j++) {
            int num = 0;
            if (i == 0){
                if (j == 0){
                    continue;
                }
                num = j;
            }else {
                num = i * 10 + j;
            }
            method(num, n);
            if (num > n){
                break;
            }
        }
    }

    public static List<Integer> method2(int n){
        List<Integer> result = new ArrayList<>();
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            result.add(tmp);
            if (tmp * 10 <= n){
                tmp *= 10;
            }else{
                while (tmp % 10 == 9 || tmp == n){
                    tmp /= 10;
                }
                tmp ++;
            }
        }
        return result;
    }
}
