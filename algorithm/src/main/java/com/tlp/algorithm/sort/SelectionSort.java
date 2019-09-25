package com.tlp.algorithm.sort;

/**
 * 选择排序，每次循环找出最小的数下标，放置于该次循环的首位
 *
 * @Description：
 * @author：tianlingpeng
 * @crateDate：2019/3/24 20:14
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = SortUtli.arr;
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                int swap = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = swap;
            }
        }
        SortUtli.print(arr);
    }
}
