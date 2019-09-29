package com.tlp.algorithm.sort;

/**
 * 选择排序，每次循环找出最小的数，放置于该次循环的首位
 *
 * @Description：
 * @author：tianlingpeng
 * @crateDate：2019/3/24 20:14
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] arr = SortUtli.arr;
        //冒泡
/*        for (int i = 0; i < arr.length-1; i++) {
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    SortUtli.swap(arr,j,j+1);
                }
            }
        }*/
        //选择
/*        for (int i = 0; i < arr.length-1; i++) {
            int minPost = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[minPost]){
                   minPost = j;
                }
            }
            if (minPost!=i){
                SortUtli.swap(arr,i,minPost);
            }
        }*/

        //插入排序
/*        for (int i = 0; i < arr.length-1; i++) {
            int current = arr[i+1];
            int prePos = i;
            while (prePos >= 0 && current < arr[prePos]) {
                arr[prePos+1] =arr[prePos];
                prePos--;
            }
            arr[prePos+1] =current;
        }*/

        int tail = arr[arr.length - 1];
        for (int i = arr.length - 2; i >=
                0; i--) {
            arr[i+1] = arr[i];

        }
        SortUtli.print(arr);
    }
}
