package jdkcontext.sort;

import java.util.Arrays;

/**
 * Created by zhong on 2016/10/12.
 *选择排序算法
 [1, 34, 6, 3, 6, 23]
 [1, 3, 6, 34, 6, 23]
 [1, 3, 6, 34, 6, 23]
 [1, 3, 6, 6, 34, 23]
 [1, 3, 6, 6, 23, 34]
 [1, 3, 6, 6, 23, 34]
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

        int minIndex = 0;
        for(int i=0; i<arr.length-1; i++) { //只需要比较n-1次
            minIndex = i;
            for(int j=i+1; j<arr.length; j++) { //从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) { //如果minIndex不为i，说明找到了更小的值，交换之。
                swap(arr, i, minIndex);
            }

            System.out.println(Arrays.toString(arr));
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int []arr={23,34,6,3,6,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
