package com.zh.mynotes.algorithm.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

       

public class Knowledge {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("student subClassOf person");
        list.add("Tom instanceOf student");
        list.add("Marry instanceOf person");
        String root = "person";
        System.out.println(solution(1, list, root));
    }

    public static List<String> solution(int n, List<String> list, String root) {
        Map<String, String> subMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        Map<String, String> instanceMap = new HashMap<>();
        for(String str : list){
            String[] strList = str.split(" ");
            if ("subClassOf".equals(strList[1])){
                subMap.put(strList[0], strList[2]);
            } else {
                instanceMap.put(strList[0], strList[2]);
            }                                      
        }
        
        instanceMap.forEach((key,value) -> {
            String classKey = value;
            do{
                if(root.equals(classKey)){
                    result.add(key);
                    break;
                }
                classKey = subMap.get(classKey);
            }while(classKey != null);
        });
        Collections.sort(result);
        return result;
    }
}