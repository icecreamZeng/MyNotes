package code.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: BG382769
 * @Description: 冒泡排序
 * @Date: Created in 2021/1/13 22:56
 */
public class BubbleSort {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(method(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
        count.set(0);
        System.out.println(Arrays.toString(method2(new int[]{26,3,2,45,9,7,4,1,2,77,6})) + "   count:"+ count.get());
    }

    private static int[] method(int[] arr) {
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0 ; j < arr.length - i - 1; j++) {
                int a = arr[j];
                int b = arr[j+1];
                if (a > b){
                    arr[ j + 1] = a;
                    arr[j] = b;
                }
                count.getAndAdd(1);
            }
        }
        return arr;
    }

    private static int[] method2(int[] arr){
        return recursion(arr,0);
    }

    private static int[] recursion(int[] arr, int index) {
        if (arr.length - index <= 1){
            return arr;
        }
        for (int i = 0 ; i < arr.length - index - 1 ; i ++){
            int a = arr[i];
            int b = arr[i + 1];
            if (a > b){
                arr[ i + 1] = a;
                arr[i] = b;
            }
            count.getAndAdd(1);
        }
        return recursion(arr, ++ index);
    }
}
