package com.tlp.algorithm.sort;

/**
 * @Description：
 * @author：tianlingpeng
 * @crateDate：2019/3/24 20:09
 */
public class SortUtli {
    public static int[] arr = {2,5,3,9,4,1,5,7,6,8};

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void swap(int[] arr ,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
