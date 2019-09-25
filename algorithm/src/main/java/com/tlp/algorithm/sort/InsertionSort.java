package com.tlp.algorithm.sort;

/**
 * @className: InsertionSort
 * @description: 插入排序
 * @author: tianlingpeng
 * @create: 2019-09-25 08:21
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = SortUtli.arr;
        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i + 1];
            int prePos = i;
            while (prePos >= 0 && current < arr[prePos]) {
                arr[prePos + 1] = arr[prePos];
                prePos--;
            }
            arr[prePos + 1] = current;
        }
        SortUtli.print(arr);
    }
}
