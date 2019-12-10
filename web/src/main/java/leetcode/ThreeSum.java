package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author zhengzp
 * 2019-12-10 19:03
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }

    /**
     * 找到所有三个数
     *
     * 1、数组排序
     * 2、先确定一个数，用 0 减去这个数得到一个数 a，在剩下数中找到两个相加等于 a 组合
     * 3、重点是过滤重复数据
     *
     * @param nums 数组
     * @return List
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (i <= nums.length - 3) {
            // 最左边的数已经大于 0 就不可能知道到 a + b + c = 0 的组合了
            if (nums[i] > 0){
                break;
            }
            // 去重
            if (i != 0 && nums[i] == nums[i - 1]){
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int next = 0 - nums[i];
            while (j < k) {
                // 去重
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                // 去重
                if (k != nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] > next) {
                    k--;
                } else if (nums[j] + nums[k] < next) {
                    j++;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    j++;
                }
            }

            i++;
        }

        return result;
    }
}
