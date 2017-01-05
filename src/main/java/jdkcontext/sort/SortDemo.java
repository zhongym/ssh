package jdkcontext.sort;

import java.util.Arrays;

/**
 * Created by zhong on 2016/10/12.
 */
public class SortDemo {
    public static void main(String[] args) {
        int []arr={4,8,1,5,7,9};
        Arrays.sort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }
}
