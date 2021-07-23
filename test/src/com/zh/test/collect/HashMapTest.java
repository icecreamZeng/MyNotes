package com.zh.test.collect;

import java.util.*;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/25 16:09
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("asdadaa","a");
        map.put("bdsad","b");
        map.put("casdada","c");
        map.containsKey("asd");
        System.out.println(map);
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("bdsad", 3);
        treeMap.put("asdadaa", 2);
        treeMap.put("casdada", 1);
        System.out.println(treeMap);
        Set<Item> itemSet = new TreeSet<>(Comparator.comparing(Item::getKey));
        itemSet.add(new Item("bdsad", 3));
        itemSet.add(new Item("asdadaa", 2));
        itemSet.add(new Item("casdada", 1));
        System.out.println(itemSet);
        Map<String, String> linkHashMap = new LinkedHashMap<>(16, 0.75F, true);
        linkHashMap.put("asdadaa","a");
        linkHashMap.put("bdsad","b");
        linkHashMap.put("casdada","c");
        System.out.println(linkHashMap);
        linkHashMap.get("bdsad");
        System.out.println(linkHashMap);
    }
}
