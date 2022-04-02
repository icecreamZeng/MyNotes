package com.zh.mynotes.algorithm.leetcode.everyday.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zeng hao
 * @Description 420. 强密码检验器
 * 如果一个密码满足下述所有条件，则认为这个密码是强密码：
 * 由至少 6 个，至多 20 个字符组成。
 * 至少包含 一个小写 字母，一个大写 字母，和 一个数字 。
 * 同一字符 不能 连续出现三次 (比如 "...aaa..." 是不允许的, 但是"...aa...a..." 如果满足其他条件也可以算是强密码)。
 * 给你一个字符串 password ，返回将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 。
 *
 * 在一步修改操作中，你可以：
 *
 * 插入一个字符到 password ，
 * 从 password 中删除一个字符，或
 * 用另一个字符来替换 password 中的某个字符。
 * 
 *
 * 示例 1：
 *
 * 输入：password = "a"
 * 输出：5
 * 示例 2：
 *
 * 输入：password = "aA1"
 * 输出：3
 * 示例 3：
 *
 * 输入：password = "1337C0d3"
 * 输出：0
 * 
 *
 * 提示：
 *
 * 1 <= password.length <= 50
 * password 由字母、数字、点 '.' 或者感叹号 '!'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strong-password-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/02 19:01
 */
public class StrongPasswordChecker {

    /* 恶心坏了，不想写了！！！！！！！！！！！！！！！！！！！！！
    * */
    public static void main(String[] args) {
        System.out.println(method2("ABABABABABABABABABAB1"));
    }

    public static int method(String password) {
        if (password == null || password.isEmpty()){
            return 6;
        }
        int length = password.length();
        boolean check1 = length >=6 && length <= 20;
        boolean check21 = false;
        boolean check22 = false;
        boolean check23 = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (!check21 && checkLetter(ch) == 1){
                check21 = true;
            }
            if (!check22 && checkLetter(ch) == 2){
                check22 = true;
            }
            if (!check23 && checkLetter(ch) == 3){
                check23 = true;
            }
            if (i <= length - 3 && password.charAt(i + 1) == ch && password.charAt(i + 2) == ch){
                int count = map.getOrDefault(i + 1, 2) + 1;
                map.put(i + 2, count);
                if (count > 3){
                    map.remove(i + 1);
                }
            }
        }
        if (check1 && check21 && check22 && check23 && map.isEmpty()){
            return 0;
        }
        int resultMin = 6 - length;
        int resultMax = length - 20;
        int result1 = length > 6 ? resultMax : resultMin;
        int result2 = 0;
        if (!check21){
            result2++;
        }
        if (!check22){
            result2++;
        }
        if (!check23){
            result2++;
        }
        AtomicInteger result3 = new AtomicInteger(0);
        Map<Integer, Integer> countMap = new HashMap<>();
        AtomicInteger countSame0 = new AtomicInteger(0);
        AtomicInteger countSame1 = new AtomicInteger(0);
        AtomicInteger countSame2 = new AtomicInteger(0);
        map.forEach((key, value) -> {
            result3.addAndGet(value / 3);
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            if (value / 3 == 0){
                countSame0.incrementAndGet();
            }if (value / 3 == 1){
                countSame1.incrementAndGet();
            }
            if (value / 3 == 2){
                countSame1.incrementAndGet();
            }

        });
        //分情况讨论
        // 1不满足，2，3满足
        if (!check1 && result2 == 0 && map.isEmpty()){
            return result1;
        }
        //13满足，2不满足
        if (check1 && result2 > 0 && map.isEmpty()){
            return result2;
        }
        //12满足，3不满足
        if (check1 && result2 == 0 && !map.isEmpty()){
            return result3.get();
        }
        //12不满足，3满足
        if (!check1 && result2 > 0 && map.isEmpty()){
            if (length > 20){
                return result1 + result2;
            }
            return Math.max(result1, result2);
        }
        //13不满足， 2满足
        if (!check1 && result2 == 0){
            if (length > 20){
                if (result1 <= countSame0.get()){
                    return result3.get();
                }else{
                    int count = result1 - countSame0.get();
                    if (count / 2 <= countSame1.get()){
                        return result3.get() + result1 - countSame0.get() + count / 2;
                    }
                    count -= countSame1.get() * 2;
                    if (count / 3 <= countSame2.get()){
                        return result3.get() + result1 - countSame0.get() - countSame1.get() * 2 - count / 3;
                    }
                    return result1;
                }
            }
            return Math.max(result1, result3.get());
        }
        //23不满足，1满足
        if (check1 && result2 > 0){
            return Math.max(result2, result3.get());
        }
        if (length > 20){
            int count = result1 - countSame0.get();
            int change = result3.get() - result1;
            if (count <= 0){
                if (change >= result2){
                    return result3.get();
                }else {
                    return result1 + result2;
                }
            }else{
                count -= countSame1.get() * 2;
                change = result3.get() - (result1 - countSame0.get())/2;
                if (count <= 0){
                    if (change >= result2){
                        //还没结束！！！！！！！！！！
                        return result3.get() + result1 - countSame0.get() - count ;
                    }
                }
            }
        }
        int max = Math.max(result2, result3.get());
        return Math.max(max, result1);
    }

    public static int checkLetter(char ch){
        if (ch >= 'a' && ch <= 'z'){
            return 1;
        }
        if (ch >= 'A' && ch <= 'Z'){
            return 2;
        }
        if (ch >= '0' && ch <= '9'){
            return 3;
        }
        return -1;
    }
    
    public static int method2(String password){
        if (password == null || password.isEmpty()){
            return 6;
        }
        int length = password.length();
        boolean check1 = length >=6 && length <= 20;
        boolean check21 = false;
        boolean check22 = false;
        boolean check23 = false;
        int result2 = 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            int check = checkLetter(ch);
            if (!check21 && check == 1){
                check21 = true;
                result2--;
            }
            if (!check22 && check == 2){
                check22 = true;
                result2--;
            }
            if (!check23 && check == 3){
                check23 = true;
                result2--;
            }
            if (i <= length - 3 && password.charAt(i + 1) == ch && password.charAt(i + 2) == ch){
                int count = map.getOrDefault(i + 1, 2) + 1;
                map.put(i + 2, count);
                if (count > 3){
                    map.remove(i + 1);
                }
            }
        }
        if (check1 && check21 && check22 && check23 && map.isEmpty()){
            return 0;
        }

        if (length < 6){
            return  Math.max(6 - length, result2);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o % 3));
        queue.addAll(map.values());
        int del = 0;
        int change = 0;
        while (!queue.isEmpty()){
            int a = queue.poll();
            if (length > 20){
                if (a > 3){
                    queue.add(a - 1);
                }
                del++;
                length--;
            }else {
                change += a/3;
            }
        }
        return del + Math.max(length - 20, 0) + Math.max(result2, change);
    }
}
