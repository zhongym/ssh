package jdkcontext.sort;

import java.util.Arrays;

/**
 * Created by zhong on 2016/10/12.
 * 冒泡排序
 *[23, 34, 6, 3, 6, 1]
 [23, 6, 34, 3, 6, 1]
 [23, 6, 3, 34, 6, 1]
 [23, 6, 3, 6, 34, 1]
 [23, 6, 3, 6, 1, 34]
 [6, 23, 3, 6, 1, 34]
 [6, 3, 23, 6, 1, 34]
 [6, 3, 6, 23, 1, 34]
 [6, 3, 6, 1, 23, 34]
 [3, 6, 6, 1, 23, 34]
 [3, 6, 6, 1, 23, 34]
 [3, 6, 1, 6, 23, 34]
 [3, 6, 1, 6, 23, 34]
 [3, 1, 6, 6, 23, 34]
 [1, 3, 6, 6, 23, 34]
 [1, 3, 6, 6, 23, 34]
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

//        for(int i=0; i<arr.length-1; i++) {
//            for(int j=arr.length-1; j>i; j--) {
//                if(arr[j] < arr[j-1]) {
//                    swap(arr, j-1, j);
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//        }

//        for (int i=0;i<arr.length-1;i++){
//            for(int j=0;j<arr.length-1;j++){
//                if(arr[j]>arr[j+1]) {
//                    swap(arr, j, j + 1);
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//        }

         for (int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]) {
                    swap(arr, j, j + 1);
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int []arr={23,34,6,3,6,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     [23, 34, 6, 3, 6, 1]
     [23, 6, 34, 3, 6, 1]
     [23, 6, 3, 34, 6, 1]
     [23, 6, 3, 6, 34, 1]
     [23, 6, 3, 6, 1, 34]
     [6, 23, 3, 6, 1, 34]
     [6, 3, 23, 6, 1, 34]
     [6, 3, 6, 23, 1, 34]
     [6, 3, 6, 1, 23, 34]
     [3, 6, 6, 1, 23, 34]
     [3, 6, 6, 1, 23, 34]
     [3, 6, 1, 6, 23, 34]
     [3, 6, 1, 6, 23, 34]
     [3, 1, 6, 6, 23, 34]
     [1, 3, 6, 6, 23, 34]
     [1, 3, 6, 6, 23, 34]
     */
}
