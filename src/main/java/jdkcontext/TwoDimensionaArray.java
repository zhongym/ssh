package jdkcontext;

import java.util.Random;

/**
 * Created by zhong on 2016/9/18.
 * 二维数据
 */
public class TwoDimensionaArray {

    public static void main(String[] args){
        int a[][]=new int[5][5];
        initArray(a);
        System.out.println("-------------------");
        show(a);
    }

    private static void show(int[][] a) {
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(a[i][j]+" "); //第一种遍历方式  a[0][0] a[0][1]
//                System.out.print(a[j][i]+" ");//第二种遍历方式 a[0][0] a[1][0]
                /**
                 * 缓存行 由于java数组在内在中分配是先分配一维数据，所以a[0][0] a[0][1]在内在中是连续的
                 * 当读取a[0][0]时，cpu会将相连的64byte的数据缓存到 缓存行（cpu缓存的最小单元 64byte）中。
                 * 所以第一种遍历方式时，当读取a[0][0]元素时，一维数组中相临的64bit会会缓存到 cpu的缓存中，所以当遍历a[0][1]时
                 * 直接从缓存行中获取即可，效率快多了
                 */
            }
            System.out.println();
        }
    }

    private static void initArray(int[][] a) {
        Random random = new Random();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                a[i][j]=random.nextInt(100);
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}
