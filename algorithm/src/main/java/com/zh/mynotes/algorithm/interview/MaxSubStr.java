package com.zh.mynotes.algorithm.interview;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/9/1 13:13
 */
public class MaxSubStr {
    public static void main(String[] args) {
        System.out.println("aabbccaaab");
    }

    public static int solution(String str){
        int length = str.length();
        int max = 0;
        for (int indexFrom = 0 ; indexFrom < length - max && indexFrom < length; indexFrom ++){
            int indexTo = 0;
            int len = max;
            indexTo = indexFrom + len -1;
            while (len <= length - indexTo - 1){
                len ++;
                indexTo = indexFrom + len;
                String s =  str.substring(indexFrom, indexTo);
                int lastIndex = str.lastIndexOf(s);
                if (lastIndex > indexTo){
                    max = len ;
                }
            }
        }
        return max;
    }
}
