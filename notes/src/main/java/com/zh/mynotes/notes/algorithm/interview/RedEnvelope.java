package com.zh.mynotes.notes.algorithm.interview;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @Author iccry
 * @Description 发红包问题
 * 100元，发10个红包
 * 每个最少0.01，最多30
 * @date 2024/4/25 19:35
 */
public class RedEnvelope {

    public static void main(String[] args) {
        BigDecimal totalAmount = new BigDecimal("100.00");
        BigDecimal min = new BigDecimal("0.01");
        BigDecimal max = new BigDecimal("30.00");
        int totalCount = 10;

        BigDecimal reminderAmount = totalAmount;
        int count = 1;
        while (count <= totalCount) {
            BigDecimal subtract = reminderAmount.subtract(max.multiply(BigDecimal.valueOf(totalCount - count))).setScale(2, RoundingMode.HALF_UP);
            BigDecimal thisMin = min.compareTo(subtract) > 0 ? min : subtract;
            BigDecimal subtract1 = reminderAmount.subtract(min.multiply(BigDecimal.valueOf(totalCount - count))).setScale(2, RoundingMode.HALF_UP);
            BigDecimal thisMax = max.compareTo(subtract1) > 0 ? subtract1 : max;
            BigDecimal redEnvelope;
            if (count < totalCount) {
                redEnvelope = randomAmount(thisMin, thisMax);
            } else {
                redEnvelope = reminderAmount;
            }
            reminderAmount = reminderAmount.subtract(redEnvelope);
            System.out.println("count = "+ count + ", redEnvelope = "+ redEnvelope + " , reminderAmount = " + reminderAmount);
            count++;
        }

    }

    private static BigDecimal randomAmount(BigDecimal min, BigDecimal max) {
        Random rand = new Random();
        return min.add(max.subtract(min)).multiply(BigDecimal.valueOf(rand.nextDouble())).setScale(2, RoundingMode.HALF_UP);
    }
}
