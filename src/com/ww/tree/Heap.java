package com.ww.tree;

import java.util.Arrays;

/**
 * 二叉堆：
 * 一种完全二叉树
 * 最大堆：任何一个父节点都大于等于他左右孩子节点的值
 * 最小堆：任何一个父节点都小于等于他左右孩子节点的值
 * 根节点叫做堆顶
 * 自我调整包括：
 * 插入节点：插入位置是完全二叉堆的最后一个位置，一直上浮到不必父节点小或者到堆顶O(logn)
 * 删除节点：删除堆顶元素，先将最后一个元素补到堆顶，和最后孩子较小的比较，比小的大的话就下沉，直到不比左右孩子大或者到叶子节点O(logn)
 * 构建二叉堆：让所有非叶子节点依次下沉。O(n)
 */
public class Heap {
    /**
     * 插入节点，上浮
     * @param arr
     */
    public static void up(int[] arr) {
        //堆为空或者只有一个元素不用调整
        if (arr == null || arr.length < 2) {
            return;
        }
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex-1)/2;
        while (childIndex > 0 && arr[childIndex] < arr[parentIndex]) {
            swap(arr, childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }

    /**
     * 删除节点，下沉
     *
     * @param arr
     */
    public static void down(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int parent = 0;
        int child = 2 * parent + 1;
        while (child < arr.length) {
            if (child + 1 < arr.length - 1 && arr[child] > arr[child + 1]) {
                child++;
            }
            if (arr[parent] > arr[child]) {
                swap(arr, parent, child);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }

        }
    }


    public static void swap(int[] arr, int childIndex, int parentIndex) {
        arr[childIndex] = arr[childIndex] ^ arr[parentIndex];
        arr[parentIndex] = arr[childIndex] ^ arr[parentIndex];
        arr[childIndex] = arr[childIndex] ^ arr[parentIndex];
    }

    /**
     * 构建二叉堆
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            downAdjust(arr, i);
        }

    }

    private static void downAdjust(int[] arr, int i) {
        int parent = i;
        int child = 2 * parent + 1;
        while (child < arr.length) {
            if (child + 1 < arr.length && arr[child] > arr[child + 1]) {
                child++;
            }
            if (arr[parent] > arr[child]) {
                swap(arr, parent, child);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 0};
        up(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {9, 8, 7, 6, 5, 4};
//        down(arr2);
//        System.out.println(Arrays.toString(arr2));
        buildHeap(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
