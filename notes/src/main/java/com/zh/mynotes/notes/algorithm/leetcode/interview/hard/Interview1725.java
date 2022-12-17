package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zeng hao
 * @Description 面试题 17.25. 单词矩阵
 * 给定一份单词的清单，设计一个算法，创建由字母组成的面积最大的矩形，其中每一行组成一个单词(自左向右)，每一列也组成一个单词(自上而下)。不要求这些单词在清单里连续出现，但要求所有行等长，所有列等高。
 *
 * 如果有多个面积最大的矩形，输出任意一个均可。一个单词可以重复使用。
 *
 * 示例 1:
 *
 * 输入: ["this", "real", "hard", "trh", "hea", "iar", "sld"]
 * 输出:
 * [
 *   "this",
 *   "real",
 *   "hard"
 * ]
 * 示例 2:
 *
 * 输入: ["aa"]
 * 输出: ["aa","aa"]
 * 说明：
 *
 * words.length <= 1000
 * words[i].length <= 100
 * 数据保证单词足够随机
 * @Date Create in 2021/11/08 17:04
 */
public class Interview1725 {
    //思路
    //1.构建字典树，方便更快的过滤无效的结果
    //2.采用回溯法，从单词长度1开始，列举所有单词长度为1的可能，得到结果，计算最值
    //3.当单词列长超过所有单词长度时停止回溯
    public static void main(String[] args) {
        String[] words = {"hv", "pi", "iu", "w", "yk", "lu", "dl", "e", "r", "pl"};
        System.out.println(Arrays.toString(maxRectangle(words)));
    }


    /* 字典树只是用来减少对单词的确认时间，只是用来check的
    *  还是要在多个可能结果中逐个排查
    * */
    public static String[] maxRectangle(String[] words){
        Map<Integer, List<String>> map = new HashMap<>();
        Node root = new Node();
        int maxLength = 0;
        AtomicInteger area = new AtomicInteger(0);
        for (String word : words) {
            int length = word.length();
            if (length >= maxLength){
                maxLength = length;
            }
            Node node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.next[index] == null){
                    node.next[index] = new Node();
                }
                node = node.next[index];
                node.ch = ch;
            }
            node.isEnd = true;
            List<String> list = map.getOrDefault(length, new ArrayList<>());
            list.add(word);
            if (list.size() <= 1){
                map.put(length, list);
            }
        }
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for (int i = maxLength; i >= 1; i--) {
            List<String> wordList = map.get(i);
            if (wordList == null){
                continue;
            }
            path.clear();
            method(root, wordList, i, maxLength, path, area, result);
        }
        return result.toArray(new String[]{});
    }

    private static void method(Node root, List<String> wordList, int length, int maxLength, List<String> path, AtomicInteger area, List<String> result) {
        if (length * maxLength < area.get() || path.size() > maxLength){
            return;
        }
        for (String word : wordList){
            path.add(word);
            int check = check(root, path);
            if (check >= 1){
                if (check == 2 && path.size() * length > area.get()){
                    area.set(path.size() * length);
                    result.clear();
                    result.addAll(path);
                }
                method(root, wordList, length, maxLength, path, area, result);
            }
            path.remove(path.size() - 1);
        }
    }

    private static int check(Node root, List<String> path) {
        int length = path.get(0).length();
        int l = path.size();
        boolean isEnd = true;
        for (int i = 0; i < length; i++) {
            Node node = root;
            for (int j = 0; j < l; j++) {
                char ch = path.get(j).charAt(i);
                int index = ch - 'a';
                node = node.next[index];
                if (node == null){
                    return 0;
                }
            }
            if (!node.isEnd){
                isEnd = false;
            }
        }
        return isEnd ? 2 : 1;
    }

    public static String[] maxRectangle2(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        for (String word : words) {
            int length = word.length();
            if (length <= minLength){
                minLength = length;
            }
            if (length >= maxLength){
                maxLength = length;
            }
            List<String> list = map.getOrDefault(length, new ArrayList<>());
            list.add(word);
            if (list.size() <= 1){
                map.put(length, list);
            }
        }

        int area = 0;
        String[] result = null;
        int row = minLength;
        while (row <= maxLength){
            int column = maxLength;
            while (row <= column){
                //难点在于，怎么确定矩阵符合结果？
                String[] temp = check(map, row, column);
                if (temp != null){
                    if (row * column > area){
                        area = row * column;
                        result = temp;
                    }
                    break;
                }
                column --;
            }
            row ++;
        }
        return result;
    }

    //关键在于给定两个数组，判断是否符合矩阵条件
    //发现最简单的还是构造字典树，那这样还不如直接构建字典树
    private static String[] check(Map<Integer, List<String>> map, int row, int column) {
        List<String> rowWords = map.get(row);
        List<String> columnWords = map.get(column);
        return  null;
    }

}
class Node{
    char ch;
    boolean isEnd = false;
    Node[] next = new Node[26];
}
