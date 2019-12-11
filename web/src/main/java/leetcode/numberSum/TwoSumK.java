package leetcode.numberSum;

import java.util.Arrays;

/**
 * 小于 K 的两数之和
 *
 * 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
 * 如不存在这样的两个元素，请返回 -1。
 *
 * 示例 1：
 *
 * 输入：A = [34,23,1,24,75,33,54,8], K = 60
 * 输出：58
 * 解释：
 * 34 和 24 相加得到 58，58 小于 60，满足题意。
 *
 *
 * 示例 2：
 *
 * 输入：A = [10,20,30], K = 15
 * 输出：-1
 * 解释：
 * 我们无法找到和小于 15 的两个元素。
 */
public class TwoSumK {
    public static void main(String[] args) {
        int[] numbers = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
        int k = 60;
        System.out.println(sumK(numbers, k));
    }

    public static int sumK(int[] nums, int target) {
        Arrays.sort(nums);

        int max = -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum >= target) {
                right--;
            } else {
                max = Math.max(max, sum);
                left++;
            }
        }
        return max;
    }
}
