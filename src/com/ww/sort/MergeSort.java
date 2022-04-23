package com.ww.sort;

/**
 * 归并排序，本质就是先让左部分有序，再让右部分有序，再将两部分合并成一个整体，使整体有序
 * 整体有序的过程使用了外排序
 * 时间复杂度是有master公式计算，时间复杂度为O（Nlog(N)）,额外空间复杂度为O(N)
 *
 */
public class MergeSort {
    /**
     * 让数组arr从left到right有序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void process(int[] arr, int left, int right) {
        //如果数组为空，或者数组长度小于2，或者左右相等不用排序天然有序
        if (arr == null || arr.length < 2 || left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);//求中点
        process(arr, left, mid);//让左部分有序
        process(arr, mid + 1, right);//让右部分有序
        merge(arr, left, mid, right);//合并左右部分
    }

    /**
     * 合并数组左右部分
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] helpArr = new int[right - left + 1];
        int p = 0;//指向中间数组的指针
        int pl = left;//指向左数组的指针
        int pr = mid + 1;//指向右数组的指针
        while (pl <= mid && pr <= right) {//左右指针是否越界
            //helpArr[p++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];//谁小复制给中间数组，并且指针后移
            if (arr[pl] <= arr[pr]) {
                helpArr[p] = arr[pl];
                pl++;
            }else {
                helpArr[p] = arr[pr];
                pr++;
            }
            p++;
        }
        while (pl <= mid) {//如果右部分全部复制完成，左部分还没复制完，左部分全部拿下来
            helpArr[p++] = arr[pl++];
        }
        while (pr <= right) {//如果左部分全部复制完，右部分还没复制完，右部分全部拿下来
            helpArr[p++] = arr[pr++];
        }
        for (int i = 0; i < helpArr.length; i++) {//将中间数组的值复制给原数组
            arr[left++] = helpArr[i];
        }
    }

}
