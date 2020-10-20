package leetcode.sortalgorithm;

import java.util.Arrays;

/**
 * 基数排序
 * <p>
 * 2020-03-18 20:17
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34, 5423, 23, 5, 634, 42, 63};
        radix(nums);
        for (int n : nums) {
            System.out.printf("%d ", n);
        }

    }

    public static void radix(int[] nums){
        int [] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
        int maxDigit = 1;
        for (int n : nums){
            if (n < 0){
                n = -n + 1;
            }
            for (int i=0; ; i++){
                if (n <= sizeTable[i]){
                    maxDigit = maxDigit < (i + 1) ? (i + 1) : maxDigit;
                    break;
                }
            }
        }

        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[20][nums.length];
            int[] idx = new int[20];

            for (int j = 0; j < nums.length; j++) {
                int bucket = ((nums[j] % mod) / dev) + 10;
                counter[bucket][idx[bucket]++] = nums[j];
            }

            int pos = 0;
            for (int k = 0; k < counter.length; k++) {
                if (idx[k] < 1){
                    continue;
                }
                int m = 0;
                while (m < idx[k]){
                    nums[pos++] = counter[k][m++];
                }
            }
        }
    }
}
