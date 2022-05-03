package com.ww.sort;

/**
 * 快速排序
 * 将数组以某个num进行分割
 * 分为<区，>区，=区，直到区域内只剩一个值
 * num为数组left到right区域内随机生成的值
 *
 */
public class QuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {//区间内有值
            swap(arr,left+(int)(Math.random()*(right-left+1)),right);//随机生成这个区间的一个随机数并和最后一位交换
            int[] index = partiton(arr, left, right);//获取左右区间的边界
            quickSort(arr, left, index[0] - 1);//左边数组继续排序
            quickSort(arr, index[1] + 1, right);//右边数组继续排序
        }
    }

    /**
     * 以num划分区域，并返回左边界和右边界的值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int[] partiton(int[] arr, int left, int right) {
        int pl = left - 1;//<区的边界
        int pr = right;//>区的边界
        while (left < pr) {
            if (arr[left] < arr[right]) {
                swap(arr, ++pl, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --pr, left);
            }else {
                left++;
            }
        }
        swap(arr,pr,right);
        return new int[]{pl+1, pr};
    }

    private void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
