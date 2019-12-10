package leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * Date: 2019-12-10 23:11
 * Copyright (C), 2015-2019
 */
public class ThreeSum2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(nums, 82));
    }

    /**
     * 参照三数之和解题
     * 1、排序
     * 2、先确定第一个
     * 3、找到剩下两个最合适的，注意过滤掉不必要的运算
     *
     * @param nums 数组
     * @param target 目标值
     * @return int
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int minDif = Math.abs(closest - target);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int left = i + 1;
            int right = length - 1;
            // 区间[left,right]内,和最小的值
            int rangeMin = nums[i] + nums[left] + nums[left + 1];
            if (rangeMin > target){
                int rangeMinDif = Math.abs(rangeMin - target);
                if (minDif >= rangeMinDif){
                    closest = rangeMin;
                    minDif = rangeMinDif;
                }
                continue;
            }

            // 区间[left,right]内,和最大的值
            int rangeMax = nums[i] + nums[right] + nums[right - 1];
            if (rangeMax < target){
                int rangeMaxDif = Math.abs(rangeMax - target);
                if (minDif >= rangeMaxDif){
                    closest = rangeMax;
                    minDif = rangeMaxDif;
                }
                continue;
            }

            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (current == target){
                    return current;
                }

                if (current > target){
                    right--;
                }else {
                    left++;
                }

                int cunDif = Math.abs(current - target);
                if (minDif >= cunDif){
                    closest = current;
                    minDif = cunDif;
                }
            }
        }

        return closest;
    }
}
