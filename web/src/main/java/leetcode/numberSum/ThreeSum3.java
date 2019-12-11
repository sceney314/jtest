package leetcode.numberSum;

import java.util.Arrays;

/**
 * 较小的三数之和
 *
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组 i, j, k 个数（0 <= i < j < k < n）。
 *
 * 例如 nums = [-2, 0, 1, 3],  target = 2.
 *
 * 返回 2. 因为有两个三元组，其总和小于2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 * Date: 2019-12-11 00:08
 * Copyright (C), 2015-2019
 */
public class ThreeSum3 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 1, 3};
        System.out.println(threeSumMin(nums, 2));
    }

    public static int threeSumMin(int[] nums, int target){
        Arrays.sort(nums);

        int find = 0;
        int length = nums.length;
        if (length < 3){
            return find;
        }
        for (int i = 0; i < length - 2; i++){
            int min = nums[i] + nums[i + 1] + nums[i + 2];
            if (min >= target){
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right){
                int current = nums[i] + nums[left] + nums[right];
                if (current < target){
                    find += right - left;
                    left++;
                }else{
                    right--;
                }
            }
        }

        return find;
    }
}
