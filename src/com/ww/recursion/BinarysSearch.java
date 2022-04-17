package com.ww.recursion;

public class BinarysSearch {


    /**
     * 一个有序数组查找某一个数字是否存在
     * 存在返回坐标，不存在返回-1如果多次返回任意一个
     */
    public int searchNum(int[] arr, int num) {
        if (arr == null || arr.length < 0) {
            return  -1;
        }
        int right = arr.length - 1;
        int light = 0;
        if (arr[right] == num) {
            return right;
        }
        if (arr[light] == num) {
            return light;
        }
        while (light <= right) {//直到左侧指针超过了右侧指针
            int mid = light + (right - light) / 2;//求中点，防止数组长度太长int超标
            if (arr[mid] == num) {//如果命中返回坐标
                return mid;
            } else if (arr[mid] > num) {//如果落在左边，右侧指针挪到中点前一位
                right = mid - 1;
            } else if (arr[mid] < num) {//如果落在右边，左侧指针挪到中点后一位
                light = mid + 1;
            }
        }
        return -1;
    }
}
