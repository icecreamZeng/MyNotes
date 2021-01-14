package code.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: BG382769
 * @Description: 插入排序
 * @Date: Created in 2021/1/14 13:54
 */
public class InsertSort {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(method(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
        count.set(0);
        System.out.println(Arrays.toString(method2(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
    }


    private static int[] method(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            int waitSort = arr[i];
            int index = i;
            for (int j = i - 1 ; j >= 0; j -- ) {
                count.getAndAdd(1);
                if (waitSort < arr[j]){
                    arr[j + 1] = arr[j];
                    index --;
                }else {
                    break;
                }
            }
            arr[index] = waitSort;
        }
        return arr;
    }


    private static int[] method2(int[] arr) {
        return recursion(arr, 1);
    }

    private static int[] recursion(int[] arr, int i) {
        if (i >= arr.length){
            return arr;
        }
        int waitSort = arr[i];
        int index = i;
        for (int j = i - 1 ; j >= 0; j -- ) {
            count.getAndAdd(1);
            if (waitSort < arr[j]){
                arr[j + 1] = arr[j];
                index --;
            }else {
                break;
            }
        }
        arr[index] = waitSort;
        return recursion(arr, i + 1);
    }
}
