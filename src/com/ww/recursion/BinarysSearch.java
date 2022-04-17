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

    /**
     * 查找一个有序数组中是否存在一个数
     * 如果存在返回这个数的最左侧坐标，不存在返回-1
     * @param arr
     * @param num
     * @return
     */
    public int searchLightNum(int[] arr, int num) {
        int index = -1;
        if (arr == null || arr.length < 0) {
            return index;
        }
        int light = 0;
        int right = arr.length - 1;
        if (arr[light] == num) {
            return light;
        }
        while (light <= right) {
            int mid = light + (right - light) / 2;
            if (arr[mid] == num) {//找到给index赋值
                index = mid;
            }
            if (arr[mid] >= num) {//找到或者落在左边，继续二分查找
//                index index= mid;
                right = mid - 1;
            }
            if (arr[mid] < num) {//落在右边继续查找
                light = mid + 1;
            }
        }
        return index;
    }
}
