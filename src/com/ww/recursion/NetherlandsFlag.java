package com.ww.recursion;

/**
 * 荷兰国旗问题：
 * 给定一个数组，在给定一个数字num，将小于num的数放在左边，大于的数放在右边，等于的数放在中间
 */
public class NetherlandsFlag {
    /**
     * 将数组从left到right用num分开
     *
     * @param arr
     * @param left
     * @param right
     */
    public void classify(int[] arr, int num, int left, int right) {
        if (right - left < 1) {//数组有少于两个元素，不需要分了
            return;
        }
        int pl = left - 1;//小于的指针
        int pr = right + 1;//大于的指针
        int p = left;//当前指针
        while (p < pr) {//当左区间没有超过右区间或者指针没有超过右区间
            if (arr[p] < num) {//小于的时候将该位置数与小于区间外的第一个数交换，左区间右移，指针右移
                swap(arr, pl+1, p);
                pl++;
                p++;
            }else if (arr[p] == num) {//等于的时候，只有指针右移
                p++;
            }else if (arr[p] > num) {//大于的时候，将该数与右区间外的第一个数交换，右区间左移，指针不动
                swap(arr, pr - 1, p);
                pr--;
            }

        }
    }

    /**
     * 交换位置，因为不能保证地址不同，所以采用原始方式
     * @param arr
     * @param pl
     * @param p
     */
    private void swap(int[] arr, int pl, int p) {
        int tmp = arr[p];
        arr[p] = arr[pl];
        arr[pl] = tmp;
    }
}
