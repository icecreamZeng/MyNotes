package com.zh.mynotes.algorithm.leetcode.interview.hard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @Author zeng hao
 * @Description 面试题 17.26. 稀疏相似度
 * 两个(具有不同单词的)文档的交集(intersection)中元素的个数除以并集(union)中元素的个数，就是这两个文档的相似度。例如，{1, 5, 3} 和 {1, 7, 2, 3} 的相似度是 0.4，其中，交集的元素有 2 个，并集的元素有 5 个。给定一系列的长篇文档，每个文档元素各不相同，并与一个 ID 相关联。它们的相似度非常“稀疏”，也就是说任选 2 个文档，相似度都很接近 0。请设计一个算法返回每对文档的 ID 及其相似度。只需输出相似度大于 0 的组合。请忽略空文档。为简单起见，可以假定每个文档由一个含有不同整数的数组表示。
 *
 * 输入为一个二维数组 docs，docs[i]表示id 为 i 的文档。返回一个数组，其中每个元素是一个字符串，代表每对相似度大于 0 的文档，其格式为 {id1},{id2}: {similarity}，其中 id1 为两个文档中较小的 id，similarity 为相似度，精确到小数点后 4 位。以任意顺序返回数组均可。
 *
 * 示例:
 *
 * 输入:
 * [
 *  [14, 15, 100, 9, 3],
 *  [32, 1, 9, 3, 5],
 *  [15, 29, 2, 6, 8, 7],
 *  [7, 10]
 * ]
 * 输出:
 * [
 *  "0,1: 0.2500",
 *  "0,2: 0.1000",
 *  "2,3: 0.1429"
 * ]
 * 提示：
 *
 * docs.length <= 500
 * docs[i].length <= 500
 * @Date Create in 2021/11/08 17:39
 */
public class Interview1726 {

    //思路：
    //最核心的问题，如何计算两个文档的相似度
    //首先是给两个文档都各自排序，比较时每个文档都有一个指针，当一个文档即将要读的数字小于另外一个文档时，排除该数字。
    public static void main(String[] args) {
        int[][] docs = {
                {14, 15, 100, 9, 3},
                {32, 1, 9, 3, 5},
                {15, 29, 2, 6, 8, 7},
                {7, 10}
        };
        List<String> result = computeSimilarities(docs);
        System.out.println(result);
    }

    public static List<String> computeSimilarities(int[][] docs){
        int length = docs.length;
        List<String> result = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                Set<Integer> set = map.get(docs[i][j]);
                if (set == null){
                    set = new HashSet<>();
                }else{
                    for (Integer k : set){
                        array[k][i]++;
                    }
                }
                set.add(i);
                if (set.size() <= 1){
                    map.put(docs[i][j], set);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int same = array[i][j];
                int num = docs[i].length + docs[j].length - same;
                double temp = (same + 0.0)/num;
                if (temp > 0){
                    String str = i + "," + j + ": " + BigDecimal.valueOf(temp).setScale(4, RoundingMode.HALF_UP);
                    result.add(str);
                }
            }
        }
        return  result;
    }

    public static List<String> computeSimilarities1(int[][] docs) {
        int length = docs.length;
        List<String> result = new ArrayList<>();
        List<Set<Integer>> setList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < docs[i].length; j++) {
                set.add(docs[i][j]);
            }
            setList.add(set);
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                double temp = calculate(setList, i, j);
                if (temp > 0){
                    String str = i + "," + j + ": " + BigDecimal.valueOf(temp).setScale(4, RoundingMode.HALF_UP);
                    result.add(str);
                }
            }
        }
        return result;
    }

    private static double calculate(List<Set<Integer>> setList, int i, int j) {
        Set set = new HashSet();
        set.addAll(setList.get(i));
        set.addAll(setList.get(j));
        int sum = setList.get(i).size() + setList.get(j).size();
        return (sum - set.size() + 0.0)/set.size();
    }

    private static double calculate(int[] doc1, int[] doc2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < doc1.length; i++) {
            set.add(doc1[i]);
        }
        int same = 0;
        for (int i = 0; i < doc2.length; i++) {
            if (set.contains(doc2[i])){
                same ++;
            }
        }
        return same /(doc1.length + doc2.length - same + 0.0);
    }

}
