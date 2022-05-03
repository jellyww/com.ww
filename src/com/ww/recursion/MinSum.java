package com.ww.recursion;

/**
 * 小合问题：归并排序的扩展
 * 给定一个数组，每个左边的数比右边的数小，把小的这些数加起来叫做这个数组的小合。
 * 逆序对问题，就是反过来的小合问题
 */
public class MinSum {
    public int  process(int[] arr, int left, int right) {
        while (arr == null || arr.length < 2 || left == right) {//如果数组为空或者长度小于2不产生小合
            return 0;
        }
        int mid = left + ((right - left) >> 1);//中点
        //合并并排序，将每次产生的小合相加
        return process(arr, left, mid) + process(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    /**
     * 排序并计算小合//不排序会导致无法计算小合
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private int merge(int[] arr, int left, int mid, int right) {
        int[] helpArr = new int[right - left + 1];
        int p = 0;
        int pl = left;
        int pr = mid + 1;
        int res = 0;//小合
        while (pl <= mid && pr <= right) {
            res += arr[pl] < arr[pr] ? arr[pl] * (right - pr + 1) : 0;//如果左边比右边小产生小合，次数为右边指针到结尾的距离+1
            helpArr[p++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];//谁小拷贝谁，相等先拷贝右侧
        }
        while (pl <= mid) {
            helpArr[p++] = arr[pl++];
        }
        while (pr <= right) {
            helpArr[p++] = arr[pr++];
        }
        for (int i = 0; i < helpArr.length; i++) {
            arr[left++] = helpArr[i];
        }
        return res;
    }

    /**
     * 暴力求解小合
     * @param arr
     * @return
     */
    public int getMinSun(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }
}
