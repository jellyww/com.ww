package com.ww.test;

import com.ww.recursion.LocalMin;
import com.ww.recursion.SearchMax;
import com.ww.sort.InsertionSort;

import java.util.Arrays;

/**
 * 对数器：使用暴力方式实现与使用算法方式做比较 看是否正确，样本可以更大，更准确
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {2, 10, 2, 3, 4, 5, 6, 2, 9, 7, 8, 9};
//        new InsertionSort().insertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(new BinarysSearch().searchLightNum(arr,8));
//        System.out.println(new LocalMin().searchLocalMin(arr));
        System.out.println(new SearchMax().process(arr,0,arr.length-1));
    }
}
