package sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: BG382769
 * @Description: 快速排序
 * @Date: Created in 2021/1/13 23:12
 */
public class QuickSort {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        int [] arr = new int[]{26,3,2,45,9,7,4,1,2,77,6};
        System.out.println(Arrays.toString(method(arr)) + "   count:"+ count.get());
        count.set(0);
    }

    private static int[] method(int[] arr) {

        return arr;
    }
}
