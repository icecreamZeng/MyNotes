package com.zh.mynotes.notes.test.collect;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/7/6 10:09
 */
@Slf4j
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> vector = new ArrayList<>();
        vector.add(123);
        vector.add(345);
        vector.add(456);
        vector.remove(Integer.valueOf(345));
        vector.forEach(e -> log.info(String.valueOf(e)));
        Set<String> set = new LinkedHashSet<>();
        set.add("q132");
        Queue<String> queue = new ArrayDeque<>();

        Map<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("1",1);
        hashtable.put("2",1);
        hashtable.put("3",1);
        hashtable.put("4",1);
        hashtable.put("5",1);
        hashtable.put("6",1);
        hashtable.put("7",1);
        hashtable.put("8",1);
        hashtable.put("9",1);
//        for (Map.Entry<String, Integer> entry : hashtable.entrySet()){
//            if (entry.getKey().equals("2")){
//                hashtable.remove(entry.getKey());
//            }
//        }
        Map<String, Integer> map = new ConcurrentHashMap<>(31);
        map.put("1",1);
        map.put("2",1);
        map.put("3",1);
        map.put("4",1);
        map.put("5",1);
        map.put("6",1);
        map.put("7",1);
        map.put("8",1);
        map.put("9",1);

        map.remove("9");

        System.out.println(map.size());
    }
}
