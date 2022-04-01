package com.zh.mynotes.algorithm.leetcode.everyday.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author zeng hao
 * @Description 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <=i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]”时，返回 true；否则，返回 false。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 
 *
 * 提示：
 *
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/01 16:01
 */
public class CanReorderDoubled {
    public static void main(String[] args) {
        int[] arr = {4,-2,2,-4};
        System.out.println(method2(arr));
    }

    /* 这种方法最直接，但是需要遍历两边
    * */
    public static boolean method1(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int i : arr) {
            queue.add(i);
        }
        while (!queue.isEmpty()){
            int a = queue.poll();
            if (a % 2 == -1){
                return false;
            }
            int b = a >= 0 ? a * 2 : a / 2;
            if (queue.contains(b)){
                queue.remove(b);
            }else{
                return false;
            }
        }
        return true;
    }

    /* 有没有一种方法，在第一次遍历的时候就知道对应的另一个元素
    * 主要问题在于，对于偶数，不能明确其在等式中的位置(arr[2 * i + 1] = 2 * arr[2 * i])
    * */
    public static boolean method2(int[] arr){
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (a >= 0){
                if (map.containsKey(a) && map.get(a) > 0){
                    if (map.get(a) == 1){
                        size--;
                    }
                    map.put(a, map.get(a) - 1);
                }else {
                    int count = map.getOrDefault(a * 2, 0);
                    if (count == 0){
                        size++;
                    }
                    map.put(a * 2,  count + 1);
                }
            }else{
                if (map.containsKey(a * 2) && map.get(a * 2) > 0){
                    if (map.get(a * 2) == 1){
                        size--;
                    }
                    map.put(a * 2, map.get(a * 2) - 1);
                }else{
                    int count = map.getOrDefault(a, 0);
                    if (count == 0){
                        size ++;
                    }
                    map.put(a, count + 1);
                }
            }
        }
        return size == 0;
    }

}
