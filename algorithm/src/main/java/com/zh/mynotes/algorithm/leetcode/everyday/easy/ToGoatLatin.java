package com.zh.mynotes.algorithm.leetcode.everyday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zeng hao
 * @Description 824. 山羊拉丁文
 * 给你一个由若干单词组成的句子sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 *
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 *
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2：
 *
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 
 *
 * 提示：
 *
 * 1 <= sentence.length <= 150
 * sentence 由英文字母和空格组成
 * sentence 不含前导或尾随空格
 * sentence 中的所有单词由单个空格分隔
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/goat-latin">https://leetcode-cn.com/problems/goat-latin</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/21 11:54
 */
public class ToGoatLatin {

    public static void main(String[] args) {
        System.out.println(method("I speak Goat Latin"));
    }

    public static String method(String sentence) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int count = 1;
        String first = "";
        boolean start = false;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ' || i == sentence.length() - 1){
                if (i == sentence.length() - 1){
                    sb.append(ch);
                }
                sb.append(first).append("ma");
                for (int j = 0; j < count; j++) {
                    sb.append("a");
                }
                if (ch == ' '){
                    sb.append(ch);
                }
                first = "";
                count ++;
                start = false;
            }else{
                if (!start && !set.contains(ch)){
                    first = "" + ch;
                }else {
                    sb.append(ch);
                }
                start = true;
            }
        }
        return sb.toString();
    }
}
