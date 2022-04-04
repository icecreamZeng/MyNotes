package com.zh.mynotes.algorithm.leetcode.everyday.hard;

import java.util.*;

/**
 * @Author zeng hao
 * @Description 1606. 找到处理最多请求的服务器
 * 你有 k个服务器，编号为 0到 k-1，它们可以同时处理多个请求组。每个服务器有无穷的计算能力但是 不能同时处理超过一个请求。请求分配到服务器的规则如下：
 *
 * 第i（序号从 0 开始）个请求到达。
 * 如果所有服务器都已被占据，那么该请求被舍弃（完全不处理）。
 * 如果第(i % k)个服务器空闲，那么对应服务器会处理该请求。
 * 否则，将请求安排给下一个空闲的服务器（服务器构成一个环，必要的话可能从第 0 个服务器开始继续找下一个空闲的服务器）。比方说，如果第 i个服务器在忙，那么会查看第 (i+1)个服务器，第 (i+2)个服务器等等。
 * 给你一个 严格递增的正整数数组arrival，表示第i个任务的到达时间，和另一个数组load，其中load[i]表示第i个请求的工作量（也就是服务器完成它所需要的时间）。你的任务是找到 最繁忙的服务器。最繁忙定义为一个服务器处理的请求数是所有服务器里最多的。
 *
 * 请你返回包含所有最繁忙服务器序号的列表，你可以以任意顺序返回这个列表。
 *
 * 
 *
 * 示例 1：
 *
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/03/load-1.png
 *
 * 输入：k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3]
 * 输出：[1]
 * 解释：
 * 所有服务器一开始都是空闲的。
 * 前 3 个请求分别由前 3 台服务器依次处理。
 * 请求 3 进来的时候，服务器 0 被占据，所以它被安排到下一台空闲的服务器，也就是服务器 1 。
 * 请求 4 进来的时候，由于所有服务器都被占据，该请求被舍弃。
 * 服务器 0 和 2 分别都处理了一个请求，服务器 1 处理了两个请求。所以服务器 1 是最忙的服务器。
 * 示例 2：
 *
 * 输入：k = 3, arrival = [1,2,3,4], load = [1,2,1,2]
 * 输出：[0]
 * 解释：
 * 前 3 个请求分别被前 3 个服务器处理。
 * 请求 3 进来，由于服务器 0 空闲，它被服务器 0 处理。
 * 服务器 0 处理了两个请求，服务器 1 和 2 分别处理了一个请求。所以服务器 0 是最忙的服务器。
 * 示例 3：
 *
 * 输入：k = 3, arrival = [1,2,3], load = [10,12,11]
 * 输出：[0,1,2]
 * 解释：每个服务器分别处理了一个请求，所以它们都是最忙的服务器。
 * 示例 4：
 *
 * 输入：k = 3, arrival = [1,2,3,4,8,9,10], load = [5,2,10,3,1,2,2]
 * 输出：[1]
 * 示例 5：
 *
 * 输入：k = 1, arrival = [1], load = [1]
 * 输出：[0]
 * 
 *
 * 提示：
 *
 * 1 <= k <= 105
 * 1 <= arrival.length, load.length <= 105
 * arrival.length == load.length
 * 1 <= arrival[i], load[i] <= 109
 * arrival保证 严格递增。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/03/30 18:05
 */
public class BusiestServers {
    public static void main(String[] args) {
        int k = 7;
        int[] arrival = {1,3,4,5,6,11,12,13,15,19,20,21,23,25,31,32};
        int[] load = {9,16,14,1,5,15,6,10,1,1,7,5,11,4,4,6};
        System.out.println(method2(k, arrival, load));
    }

    public static List<Integer> method(int k, int[] arrival, int[] load) {
        int[][] times = new int[k][2];
        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int i = 0; i < k; i++) {
            queue.add(0);
        }
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            int need = load[i];
            if (queue.peek() > time){
                continue;
            }
            for (int j = 0; j < k; j++) {
                int index = (j + i) % k;
                if(times[index][0] <= time){
                    queue.remove(times[index][0]);
                    times[index][0] = time + need;
                    queue.add(time + need);
                    if (max < ++times[index][1]){
                        max++;
                    }
                    break;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (times[i][1] == max){
                list.add(i);
            }
        }
        return list;
    }

    //利用 treeset.ceiling() 方法查找最近的空闲服务器，笑了
    public static List<Integer> method2(int k, int[] arrival, int[] load){
        PriorityQueue<Integer[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        TreeSet<Integer> free = new TreeSet<>();
        int[] count = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            while (!busy.isEmpty() && busy.peek()[1] <= time){
                free.add(busy.poll()[0]);
            }
            Integer target = free.ceiling(i % k);
            if (target == null ){
               if ((target = free.ceiling(0)) == null){
                   continue;
               }
            }
            free.remove(target);
            busy.add(new Integer[]{target, time + load[i]});
            if (max < ++ count[target]){
                max++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max){
                list.add(i);
            }
        }
        return list;
    }
}