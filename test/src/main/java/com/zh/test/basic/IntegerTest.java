package com.zh.test.basic;

/**
 * @Author: Zeng Hao
 * @Description:
 * @Date: Created in 2021/6/25 22:12
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 200;
        Integer b = 200;
        Long c = 400L;
        System.out.println(a == b);
        System.out.println(c == a + b);
        System.out.println(c == 400);
        System.out.println(a + b == 399 + 1.0);
        //System.out.println(c.equals(a + b));
    }
}
