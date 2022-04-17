package com.ww.recursion;

public class LocalMin {

    /**
     * 给定一个无序的数组，已知相邻两个数不相等，求出一个局部最小值
     * 0位置数只需要满足比1位置数小即为局部最小值，
     * arr.length-1位置数只需要满足比arr.length-2位置数小即为局部最小值
     * n位置数需要满足比n-1和 n-2位置数都小才为局部最小值
     * @param arr
     * @return
     */
    public int searchLocalMin(int[] arr) {
        if (arr == null || arr.length < 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int light = 1;
        int rigth = arr.length - 2;
        while (light <= rigth) {
            int mid = light + ((rigth - light)>>1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return arr[mid];
            }
            if (arr[mid] > arr[mid - 1]) {//中间数比前一位大，在前一半找
                rigth = mid - 1;

            }
            if (arr[mid] > arr[mid + 1]) {//中间数比后一位大，在后一半找
                light = mid + 1;
            }
        }
        return -1;
    }
}
