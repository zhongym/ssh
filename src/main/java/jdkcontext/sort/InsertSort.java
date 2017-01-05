package jdkcontext.sort;

import java.util.Arrays;

/**
 * Created by zhong on 2016/10/12.
 * 插入排序
 [23, 34, 6, 3, 6, 1]
 [6, 23, 34, 3, 6, 1]
 [3, 6, 23, 34, 6, 1]
 [3, 6, 6, 23, 34, 1]
 [1, 3, 6, 6, 23, 34]
 [1, 3, 6, 6, 23, 34]
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

        for(int i=1; i<arr.length; i++) { //假设第一个数位置时正确的；要往后移，必须要假设第一个。

            int j = i;
            int target = arr[i]; //待插入的

            //后移
            while(j > 0 && target < arr[j-1]) {
                arr[j] = arr[j-1];
                j --;
            }

            //插入
            arr[j] = target;

            System.out.println(Arrays.toString(arr));
        }

    }
    public static void main(String[] args) {
        int []arr={23,34,6,3,6,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
