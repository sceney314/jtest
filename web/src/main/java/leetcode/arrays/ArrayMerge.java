package leetcode.arrays;

/**
 * Date: 2020-07-28 09:54
 * Copyright (C), 2015-2020
 */
public class ArrayMerge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for(int n : nums1){
            System.out.printf("%d ", n);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 反向思维，从大到小
        int p = n + m - 1, k = m - 1, g = n - 1;
        while (k >= 0 && g >= 0) {
            if (nums1[k] <= nums2[g]) {
                nums1[p--] = nums2[g--];
            } else {
                nums1[p--] = nums1[k--];
            }
        }

        if (k >= 0) {
            while (k >= 0) {
                nums1[p--] = nums1[k--];
            }
        } else if (g >= 0) {
            while (g >= 0) {
                nums1[p--] = nums2[g--];
            }
        }
    }
}
