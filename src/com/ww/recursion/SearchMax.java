package com.ww.recursion;

/**
 * 使用递归获取到一个数组中的最大值
 */
public class SearchMax {
    /**
     * 获取数组中从left到rigth上的最大值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int process(int[] arr, int left, int right) {
        if (left == right) {//如果从left到right只有一个数返回这个数
            return arr[left];
        }
        int mid = left + ((right - left) >> 2);//求中点
        int leftMax = process(arr, left, mid);//求出数组左半部最大值
        int rightMax = process(arr, mid + 1, right);//求出数组右半部最大值
        return Math.max(leftMax, rightMax);//返回左右两边最大的值
    }
}
