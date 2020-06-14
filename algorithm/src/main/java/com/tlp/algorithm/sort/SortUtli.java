package com.tlp.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description：
 * @author：tianlingpeng
 * @crateDate：2019/3/24 20:09
 */
public class SortUtli {
    public static int[] arr = { 2, 5, 3, 9, 4, 1, 5, 7, 6, 8,8 };

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        //冒泡排序

/*
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
*/

        //选择排序
/*        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }*/

        //插入排序
/*        for (int i = 0; i < arr.length - 1; i++) {
            int pos =i;
            int current =arr[i+1];
            while (pos>=0&&current<arr[pos]){
                arr[pos + 1] = arr[pos];
                pos--;
            }
            arr[pos+1] = current;
        }*/

        List<int[]> arrList = Arrays.asList(arr);

        print(arr);
        int var =1;
        int varcase = 1;
        switch (varcase){
        case 1:

        }
    }


}
