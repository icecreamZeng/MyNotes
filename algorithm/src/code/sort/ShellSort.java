package code.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: BG382769
 * @Description: 希尔排序
 * @Date: Created in 2021/1/14 14:48
 */
public class ShellSort {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(method(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
        count.set(0);
        System.out.println(Arrays.toString(method2(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
    }

    private static int[] method(int[] arr) {
        return arr;
    }
    private static int[] method2(int[] arr) {
        return arr;
    }
}
