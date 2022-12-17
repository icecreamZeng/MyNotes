package com.zh.mynotes.notes.algorithm.leetcode.competition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author zeng hao
 * @Description
 * @Date Create in 2022/06/12 11:36
 */

public class CompanyRename {

    public static void main(String[] args) {
        String[] ideas = {"coffee", "donuts", "time", "toffee"};
        System.out.println(method(ideas));
    }

    private static int method(String[] ideas) {
        if (ideas == null || ideas.length <=0){
            return 0;
        }
        Set<String> set = new HashSet<>(Arrays.asList(ideas));
        int n = ideas.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String ideaA = ideas[i];
                String ideaB = ideas[j];
                if (!have(set, ideaA, ideaB)){
                    count +=2;
                }
            }
        }
        return count;
    }

    private static boolean have(Set<String> set, String ideaA, String ideaB) {
        String tmpA = ideaB.charAt(0) + ideaA.substring(1);
        String tmpB = ideaA.charAt(0) + ideaB.substring(1);
        return set.contains(tmpA) || set.contains(tmpB);
    }
}
