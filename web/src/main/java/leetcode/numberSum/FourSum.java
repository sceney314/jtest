package leetcode.numberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * @author zhengzp
 * 2019-12-10 20:48
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    /**
     * 四数之和
     *
     * 同三数之和计算，确定前两个找剩下俩
     * 1、确定第一个
     * 2、在排除已确定的，剩下的中确定第二个
     * 3、在排除已确定的第一个和第二个中找剩下的两个
     * 4、每一步记得去重
     *
     * @param nums   数组
     * @param target 目标值
     * @return List
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        // 定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值
        // 确定第一个
        for (int k = 0; k < length - 3; k++) {
            // 当k的值与前面的值相等时忽略
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }

            // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }

            // 确定第二个
            for (int i = k + 1; i < length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 定义指针j指向i+1
                int j = i + 1;
                // 定义指针h指向数组末尾
                int h = length - 1;
                // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                // 开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

}
