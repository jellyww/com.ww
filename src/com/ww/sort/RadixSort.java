package com.ww.sort;

/**
 * 桶排序，基数排序
 * 1.取出最高位数
 * 2.将不足最高位的左边补0
 * 3.准备0～9号桶
 * 4.从个位开始依次进入对应的桶，然后在出桶，直到最高位结束排序，
 * 5.将辅助数组复制回原数组
 */
public class RadixSort {
    public void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //让数组l到R有序
        radixSort(arr,0,arr.length-1,maxBit(arr));

    }

    /**
     * 基数排序
     *
     * @param arr
     * @param l
     * @param r
     * @param maxBit
     */
    private void radixSort(int[] arr, int l, int r, int maxBit) {
        //准备一个和数组长度一样的辅助数组
        int[] backet = new int[r - l + 1];
        int radix = 10;
        for (int i = 1; i <= maxBit; i++) {//z最高位是几位循环几次
            int[] count = new int[radix];//准备一个计数数组
            //count数组对应位数表示当前位出现的次数
            //count[0]表示i位置所有数据0出现的次数
            //count[i]表示当前位置0～i数据出现的次数
            for (int j = l; j <= r; j++) {//统计i位置cou出现的次数
                int cou = getDigit(arr[j], i);//依次取出数组里所有元素I位置上的数
                count[cou]++;
            }
            //记录和
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }
            //倒叙遍历原数组，确定每个元素的位置
            for (int j = r; j >= l; j--) {
                int ind = getDigit(arr[j], i);
                backet[count[ind] - 1] = arr[j];
                count[ind]--;
            }
            //将辅助数组元素复制回原数组
            for (int j = l,d = 0; j <= r; j++,d++) {
                arr[j] = backet[d];
            }

        }
    }

    /**
     * 取出 i数据，index位置上的数
     * @param i
     * @param index
     * @return
     */
    public int getDigit(int i, int index) {
        return ((i / ((int) (Math.pow(10, index - 1)))) % 10);
    }

    /**
     * 获取到数据元素的最高位
     * @param arr
     * @return
     */
    public int maxBit(int[] arr) {
        int max = Integer.MIN_VALUE;//整数的最小值
        for (int i = 0; i < arr.length; i++) {//取出数组最大值
            max = Math.max(max, arr[i]);
        }
        int res = 0;//最高位数
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }


}
