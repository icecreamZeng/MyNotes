package code.leetcode.interview.easy;

/**
 * @Author: Zeng Hao
 * @Description: 面试题 01.01. 判定字符是否唯一
 *实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。

 * @Date: Created in 2021/1/6 0:00
 */
public class Interview0101 {
    public static void main(String[] args) {
        System.out.println(isUnique("a"));
    }

    public static boolean isUnique(String astr) {
        if (astr.length() <= 1){
            return true;
        }
        String a = astr.substring(0, 1);
        String str = astr.substring(1);
        return method(a,str);
    }

    public static boolean method(String a , String str){
         if (str.length() ==1){
             return !str.equals(a);
         }
         if (str.contains(a)){
             return false;
         }
         return method(str.substring(0,1), str.substring(1));
    }
}
