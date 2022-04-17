package com.ww.xor;

public class OneNum {
    /**
     *
     * @param args
     * ^：异或，相同0，不同1。相当于无进位相加；
     *   符合交换律和结合律
     *   0^N = N; N^N = 0;
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6,7};
//        System.out.println(searchOne(arr));
        searchTwo(arr);
    }

    /**
     *
     * @param arr
     * @return
     * 一个数组中只有一个书出现了奇数次，其他都是出现了偶数次，找出这个数
     */
    public static int searchOne(int[] arr){
        int eor = 0;
        for (int num : arr){
            eor ^= num;
        }
        return eor;
    }

    /**
     *
     * @param arr
     * 一个数组中只有两个数出现了奇数次，其他数出现了偶数次，
     */
    public static void searchTwo(int[] arr) {
        int eor = 0;
        //1。先数组里的数全^一次，得倒 a^b
        for (int num : arr) {
            eor ^= num;
        }//eor = a ^ b
        int eorr = 0;
        //2。求出 a^b最右边的1
        int rightOne = eor & (~eor + 1);//求出最右边一个1
        //3。将对应位数不是1的数全都取出来，相当于只有一个奇数
        for (int num : arr) {
            if ((num & rightOne) == 0) {//最右边相同位数不是1
                eorr ^= num;
            }
        }
        System.out.println(eorr);
        System.out.println(eorr^eor);
    }
}
