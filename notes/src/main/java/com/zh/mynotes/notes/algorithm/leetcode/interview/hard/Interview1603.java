package com.zh.mynotes.notes.algorithm.leetcode.interview.hard;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 
 * @Author zeng hao
 * @Description 面试题 16.03. 交点
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 *
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 *
 * 示例 1：
 *
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 * 示例 2：
 *
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 * 示例 3：
 *
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 * 
 *
 * 提示：
 *
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 *
 * @Date Create in 2021/11/5 20:11
 */
@Slf4j
public class Interview1603 {
    
    public static void main(String[] args) {
        int[] start1 = {-25,67};
        int[] end1 = {-67, 24};
        int[] start2 = {-52, 48};
        int[] end2 = {-45, 43};
        double [] res = intersection(start1, end1, start2, end2);
        log.info("{"+ res[0] +", "+ res[1] +"}");
    }

    // 个人感觉这个题没必要过分纠结，按照正常的函数逻辑来计算就行
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        //1.得到两个函数方程
        //2.计算交点
        //3.验算

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        //需要考虑 斜率不存在的情况 即 y1=y2
        if (line1.k == null || line2.k == null){
            if (line1.k == null && line2.k == null){
                if (line1.b.compareTo(line2.b) == 0){
                    if (line1.start[1] < line2.start[1]){
                        if (line2.start[1] <= line1.end[1]){
                            return new double[]{line2.start[0], line2.start[1]};
                        }
                    }else {
                        if (line1.start[1] <= line2.end[1]){
                            return new double[]{line1.start[0], line1.start[1]};
                        }
                    }
                }else {
                    return new double[]{};
                }
            } else if (line1.k == null){
                BigDecimal x = line1.b;
                BigDecimal y = x.multiply(line2.k).add(line2.b);
                return y.doubleValue() >= line1.start[1] && y.doubleValue()  <= line1.end[1] ? new double[]{x.doubleValue(), y.doubleValue()} : new double[]{};
            }else {
                BigDecimal x = line2.b;
                BigDecimal y = x.multiply(line1.k).add(line1.b);
                return y.doubleValue() >= line2.start[1] && y.doubleValue()  <= line2.end[1] ? new double[]{x.doubleValue(), y.doubleValue()} : new double[]{};
            }
            return new double[]{};
        }
        //正常情况
        if (line1.k.compareTo(line2.k) == 0){
            if (line1.b.compareTo(line2.b) == 0){
                //若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
                if (line1.start[0] < line2.start[0]){
                    if (line2.start[0] <= line1.end[0]){
                        return new double[]{line2.start[0], line2.start[1]};
                    }
                }else {
                    if (line1.start[0] <= line2.end[0]){
                        return new double[]{line1.start[0], line1.start[1]};
                    }
                }
            }else {
                return new double[]{};
            }
        }else{
            BigDecimal x = line2.b.subtract(line1.b).divide(line1.k.subtract(line2.k), 6, BigDecimal.ROUND_HALF_UP);
            BigDecimal y = line1.k.multiply(x).add(line1.b);
            double dx = x.doubleValue();
            return dx >= line1.start[0] && dx <= line1.end[0] && dx >= line2.start[0] && dx <= line2.end[0] ? new double[]{x.doubleValue(), y.doubleValue()} : new double[]{};
        }
        return new double[]{};
    }

    //既然不知道怎么表示线段，那就另外指定一个类

}

class Line{
    int[] start;
    int[] end;
    BigDecimal k = null;
    BigDecimal b = null;

    Line(int[] start, int[] end){
        if (start[0] < end[0] || (start[0] == end[0] && start[1] < end[1])){
            this.start = start;
            this.end = end;
        }
        else{
            this.start = end;
            this.end = start;
        }

        k = start[0] == end[0] ? null : BigDecimal.valueOf(((end[1] - start[1]) * 1.0)/(end[0] - start[0]));
        b = k == null ? BigDecimal.valueOf(start[0]) : BigDecimal.valueOf(start[1] - k.doubleValue() * start[0]);
    }
}
