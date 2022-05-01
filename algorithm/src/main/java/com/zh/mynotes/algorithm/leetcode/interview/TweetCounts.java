package com.zh.mynotes.algorithm.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zeng Hao
 * @Description:
 * //请你实现一个能够支持以下两种方法的推文计数类 TweetCounts：
 *
 * 1.recordTweet(string tweetName, int time)
 *
 * 记录推文发布情况：用户 tweetName 在 time（以 秒 为单位）时刻发布了一条推文。
 * 2.getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int endTime)
 *
 * 返回从开始时间 startTime（以 秒 为单位）到结束时间 endTime（以 秒 为单位）内，每 分 minute，时 hour 或者 日 day （取决于 freq）内指定用户 tweetName 发布的推文总数。
 * freq 的值始终为 分 minute，时 hour 或者 日 day 之一，表示获取指定用户 tweetName 发布推文次数的时间间隔。
 * 第一个时间间隔始终从 startTime 开始，因此时间间隔为 [startTime, startTime + delta*1>,  [startTime + delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... , [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)>，其中 i 和 delta（取决于 freq）都是非负整数。
 *
 * 解释：
 * TweetCounts tweetCounts = new TweetCounts();
 * tweetCounts.recordTweet("tweet3", 0);
 * tweetCounts.recordTweet("tweet3", 60);
 * tweetCounts.recordTweet("tweet3", 10);                             // "tweet3" 发布推文的时间分别是 0, 10 和 60 。
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // 返回 [2]。统计频率是每分钟（60 秒），因此只有一个有效时间间隔 [0,60> - > 2 条推文。
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。
 * tweetCounts.recordTweet("tweet3", 120);                            // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
 * tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);
 * @Date: Created in 2021/3/11 21:05
 */
public class TweetCounts {

    //1.时：24，分： 24*60，秒：24*60*60

    Map<Integer, Map<String, Integer>> dayCountMap = new HashMap<>();

    Map<Integer, Map<String, Integer>> hourCountMap = new HashMap<>();

    Map<Integer, Map<String, Integer>> minuteCountMap = new HashMap<>();

    Map<Integer, Map<String, Integer>> secondCountMap = new HashMap<>();

   void recordTweet(String tweetName, int time){
        //计算time 所在时分秒
       int minute = time / 60 + time % 60 > 0 ? 1 : 0;
       int hour = minute / 60 + minute % 60 > 0 ? 1 : 0;
       int day = hour / 24 + hour % 24 > 0 ? 1 : 0;
       setUserCount(secondCountMap, time, tweetName);
       setUserCount(minuteCountMap, minute, tweetName);
       setUserCount(hourCountMap, hour, tweetName);
       setUserCount(dayCountMap, day, tweetName);
   }

    private void setUserCount(Map<Integer, Map<String, Integer>> secondCountMap, int time, String tweetName) {
        Map<String, Integer> userCountMap = secondCountMap.get(time);
        if (userCountMap == null){
            userCountMap = new HashMap<>();
            userCountMap.put(tweetName, 1);
            secondCountMap.put(time, userCountMap);
        }else {
            int count = userCountMap.getOrDefault(tweetName, 0);
            userCountMap.put(tweetName, ++ count);
        }
    }

    //日，时，分
   //tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);
   int[] getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime){
       //思路： 计算出 从 startTime 到 endTime 时间 整段的时间
       int second1 = startTime % 60 ;
       int startTimeTo = startTime + second1 > 0 ? (60 - second1) : 0;
       int second2 = endTime % 60;
       int endTimeFrom = endTime - second1;

       //计算time 所在时分秒
       int minute1 = startTime / 60 + startTime % 60 > 0 ? 1 : 0;
       int hour1 = minute1 / 60 + minute1 % 60 > 0 ? 1 : 0;
       int day1 = hour1 / 24 + hour1 % 24 > 0 ? 1 : 0;
       return null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(list.toString());
        System.out.println(list.contains(1));
    }
}
