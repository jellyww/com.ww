package com.ww.sort;

import com.ww.recursion.BinarysSearch;

import java.util.Arrays;

/**
 * 插入排序：
 * 先让0～0有序
 * 再让0～i有序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 2, 9, 7, 8, 0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(new BinarysSearch().searchNum(arr,5));
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {//数组为空或者长度为1不需要排序
            return;
        }
        for (int i = 1; i < arr.length; i++) {//做到0～i有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {//j和后一位数比较，j大于后一位，j位置数后移，直到j到头或者j小于后一位
                swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 交换数组两个数的位置
     * 注意i!=j是可用
     * @param arr
     * @param j
     * @param i
     */
    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
