package com.ww.test;

import com.ww.recursion.BinarysSearch;
import com.ww.sort.InsertionSort;

import java.util.Arrays;

/**
 * 对数器：使用暴力方式实现与使用算法方式做比较 看是否正确，样本可以更大，更准确
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3, 4, 3, 6, 2, 9, 7, 8, 0};
        new InsertionSort().insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(new BinarysSearch().searchLightNum(arr,8));
    }
}
