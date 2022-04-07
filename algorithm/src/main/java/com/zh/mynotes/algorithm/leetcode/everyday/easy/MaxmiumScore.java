package com.zh.mynotes.algorithm.leetcode.everyday.easy;

import java.util.Arrays;

/**
 * @Author zeng hao
 * @Description LCP 40. 心算挑战
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
 * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 *
 * 示例 1：
 *
 * 输入：cards = [1,2,8,9], cnt = 3
 *
 * 输出：18
 *
 * 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
 *
 * 示例 2：
 *
 * 输入：cards = [3,3,1], cnt = 1
 *
 * 输出：0
 *
 * 解释：不存在获取有效得分的卡牌方案。
 *
 * 提示：
 *
 * 1 <= cnt <= cards.length <= 10^5
 * 1 <= cards[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/uOAnQW
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date Create in 2022/04/07 19:52
 */
public class MaxmiumScore {
    public static void main(String[] args) {

    }

    public static int method(int[] cards, int cnt) {
        int sum = 0;
        Arrays.sort(cards);
        int count = 0;
        int oddMin = -1;
        int evenMin = -1;
        for (int i = cards.length -1; i >= 0; i--) {
            int num = cards[i];
            if (count < cnt){
                if (num % 2 == 1){
                    if (oddMin == -1 || oddMin > num){
                        oddMin = num;
                    }
                }else{
                    if (evenMin == -1 || evenMin > num){
                        evenMin = num;
                    }
                }
                sum += num;
                count++;
                continue;
            }
            if (sum % 2 == 0){
                return sum;
            }
            if (num % 2 == 1){
                if (evenMin > -1){
                    sum -= evenMin;
                    sum += num;
                }
            }else {
                if (oddMin > -1){
                    sum -= oddMin;
                    sum += num;
                }
            }
        }
        return sum % 2 == 0 ? sum : 0;
    }
}
