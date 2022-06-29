package com.ww.test;

import com.ww.recursion.LocalMin;
import com.ww.recursion.MinSum;
import com.ww.recursion.NetherlandsFlag;
import com.ww.recursion.SearchMax;
import com.ww.sort.InsertionSort;
import com.ww.sort.MergeSort;
import com.ww.sort.QuickSort;
import com.ww.sort.RadixSort;

import java.util.Arrays;

/**
 * 对数器：使用暴力方式实现与使用算法方式做比较 看是否正确，样本可以更大，更准确
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {2, 10, 2, 3, 5, 6, 4, 2, 9, 97, 8, 9,100};//18+16+21+24+25+24+8+14+8
//        new InsertionSort().inclassifysertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(new BinarysSearch().searchLightNum(arr,8));
//        System.out.println(new LocalMin().searchLocalMin(arr));
//        System.out.println(new SearchMax().process(arr,0,arr.length-1));
//        new MergeSort().process(arr,0,arr.length-1);1
//        System.out.println(new MinSum().getMinSun(arr));
//        int sum = new MinSum().process(arr, 0, arr.length - 1);
//        System.out.println(sum);
//        new NetherlandsFlag().classify(arr,5,0,arr.length-1);
//        new QuickSort().quickSort(arr,0,arr.length-1);
//        new QuickSort().sort(arr);
        new RadixSort().radixSort(arr);
//        System.out.println(new RadixSort().getDigit(200,3));
        System.out.println(new RadixSort().maxBit(arr));
        System.out.println(Arrays.toString(arr));

    }
}
