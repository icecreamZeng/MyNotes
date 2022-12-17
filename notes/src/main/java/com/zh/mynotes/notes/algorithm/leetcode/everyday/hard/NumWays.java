package com.zh.mynotes.notes.algorithm.leetcode.everyday.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zeng hao
 * @Description 1639. 通过给定词典构造目标字符串的方案数
 * 给你一个字符串列表 words和一个目标字符串target 。words 中所有字符串都长度相同。
 *
 * 你的目标是使用给定的 words字符串列表按照下述规则构造target：
 *
 * 从左到右依次构造target的每一个字符。
 * 为了得到target 第i个字符（下标从 0开始），当target[i] = words[j][k]时，你可以使用words列表中第 j个字符串的第 k个字符。
 * 一旦你使用了 words中第 j个字符串的第 k个字符，你不能再使用 words字符串列表中任意单词的第 x个字符（x <= k）。也就是说，所有单词下标小于等于 k的字符都不能再被使用。
 * 请你重复此过程直到得到目标字符串target。
 * 请注意， 在构造目标字符串的过程中，你可以按照上述规定使用 words列表中 同一个字符串的 多个字符。
 *
 * 请你返回使用 words构造 target的方案数。由于答案可能会很大，请对 109 + 7取余后返回。
 *
 * （译者注：此题目求的是有多少个不同的 k序列，详情请见示例。）
 *
 * 
 *
 * 示例 1：
 *
 * 输入：words = ["acca","bbbb","caca"], target = "aba"
 * 输出：6
 * 解释：总共有 6 种方法构造目标串。
 * "aba" -> 下标为 0 ("acca")，下标为 1 ("bbbb")，下标为 3 ("caca")
 * "aba" -> 下标为 0 ("acca")，下标为 2 ("bbbb")，下标为 3 ("caca")
 * "aba" -> 下标为 0 ("acca")，下标为 1 ("bbbb")，下标为 3 ("acca")
 * "aba" -> 下标为 0 ("acca")，下标为 2 ("bbbb")，下标为 3 ("acca")
 * "aba" -> 下标为 1 ("caca")，下标为 2 ("bbbb")，下标为 3 ("acca")
 * "aba" -> 下标为 1 ("caca")，下标为 2 ("bbbb")，下标为 3 ("caca")
 * 示例 2：
 *
 * 输入：words = ["abba","baab"], target = "bab"
 * 输出：4
 * 解释：总共有 4 种不同形成 target 的方法。
 * "bab" -> 下标为 0 ("baab")，下标为 1 ("baab")，下标为 2 ("abba")
 * "bab" -> 下标为 0 ("baab")，下标为 1 ("baab")，下标为 3 ("baab")
 * "bab" -> 下标为 0 ("baab")，下标为 2 ("baab")，下标为 3 ("baab")
 * "bab" -> 下标为 1 ("abba")，下标为 2 ("baab")，下标为 3 ("baab")
 * 示例 3：
 *
 * 输入：words = ["abcd"], target = "abcd"
 * 输出：1
 * 示例 4：
 *
 * 输入：words = ["abab","baba","abba","baab"], target = "abba"
 * 输出：16
 * 
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words中所有单词长度相同。
 * 1 <= target.length <= 1000
 * words[i]和target都仅包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/07 20:17
 */
public class NumWays {
    public static void main(String[] args) {
        String[] words = {"cbabddddbc","addbaacbbd","cccbacdccd","cdcaccacac","dddbacabbd","bdbdadbccb","ddadbacddd","bbccdddadd","dcabaccbbd","ddddcddadc","bdcaaaabdd","adacdcdcdd","cbaaadbdbb","bccbabcbab","accbdccadd","dcccaaddbc","cccccacabd","acacdbcbbc","dbbdbaccca","bdbddbddda","daabadbacb","baccdbaada","ccbabaabcb","dcaabccbbb","bcadddaacc","acddbbdccb","adbddbadab","dbbcdcbcdd","ddbabbadbb","bccbcbbbab","dabbbdbbcb","dacdabadbb","addcbbabab","bcbbccadda","abbcacadac","ccdadcaada","bcacdbccdb"};
        String target = "bcbbcccc";
        System.out.println(method2(words, target));
    }

    static int result = 0;
    static List<Integer>[] dp;
    public static int method(String[] words, String target) {
        dp = new List[target.length()];
        dfs(words, target, 0, 0);
        return result;
    }

    public static void dfs(String[] words, String target, int idx, int index){
        if (index>= target.length()){
            result++;
            return;
        }
        if (idx >= words[0].length()){
            return;
        }
        if (target.length() - index > words[0].length() - idx){
            return;
        }
        List<Integer> list = dp[index];
        if (list == null){
            List<Integer> tmp = new ArrayList<>();
            do {
                for (String word : words) {
                    if (word.charAt(idx) == target.charAt(index)) {
                        dfs(words, target, idx + 1, index + 1);
                        tmp.add(idx);
                    }
                }
                idx ++;
            }while (idx < words[0].length());
            dp[index] = tmp;
        }else{
            for (Integer i : list) {
                if (i >= idx){
                    dfs(words, target, i + 1, index + 1);
                }
            }
        }
    }

    //最优子结构+状态方程

    public static int method2(String[] words, String target){
        int[][] dp2 = new int[target.length()][words[0].length()];
        long mod = (long)(Math.pow(10 ,9) + 7);
        int[][] count = new int[26][words[0].length()];
        for (int j = 0; j < words[0].length(); j++) {
            for (String word : words){
                int i = word.charAt(j) - 'a';
                count[i][j]++;
            }
        }

        for (int i = 0; i < target.length(); i++) {
            for (int j = i; j < words[0].length(); j++) {
               //dp[i][j] = dp[i-1][j-1] * k +dp[i][j-1]
               int k = count[target.charAt(i) - 'a'][j];
               if (i == 0){
                   dp2[i][j] = (int) (((j == 0 ? 0 : dp2[i][j - 1]) + k) % mod);
               }else {
                    dp2[i][j] = (int)(((long)dp2[i-1][j - 1] * k + (long)dp2[i][j-1]) % mod);
               }
            }
        }
        return dp2[target.length()-1][words[0].length() - 1];
    }
}
