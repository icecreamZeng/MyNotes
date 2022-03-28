package com.zh.mynotes.algorithm.sort.interview;

import java.util.*;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/9/8 19:38
 */
public class Depend {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String targetModuleName = scan.nextLine();
        Map<String, List<String>> depend = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            List<String> list= Arrays.asList(line.split(","));
            if (list.size() <2){
                break;
            }
            String moduleName = list.get(0);
            int time = Integer.parseInt(list.get(1));
            if (list.size() <= 2){
                timeMap.put(moduleName, time);
            } else {
                depend.put(moduleName, list);
            }
        }
        scan.close();
        int time = solution(targetModuleName, timeMap, depend);
        System.out.println(time);
    }

    private static int solution(String targetModuleName, Map<String, Integer> timeMap, Map<String, List<String>> depend) {
        Integer time = timeMap.get(targetModuleName);
        if (time != null){
            return time;
        }
        Deque<String> deque = new ArrayDeque<>();
        deque.push(targetModuleName);
        do{
            String findName = deque.getLast();
            List<String> list = depend.get(findName);
            if (list == null){
                return -1;
            }
            int maxTime = 0;
            boolean complete = true;
            for (int i = 2 ; i < list.size(); i ++){
                String moduleName = list.get(i);
                if (deque.contains(moduleName)){
                    return -1;
                }
                Integer childTime = timeMap.get(moduleName);
                if (childTime != null){
                    timeMap.put(moduleName, childTime);
                    if (childTime >= maxTime){
                        maxTime = childTime;
                    }
                } else {
                    deque.push(moduleName);
                    complete = false;
                }
            }
            if (complete){
                deque.pop();
                int findTime = Integer.parseInt(list.get(1));
                timeMap.put(findName, findTime + maxTime);
            }
        }while(!deque.isEmpty());
       return timeMap.getOrDefault(targetModuleName, -1);
    }

}
