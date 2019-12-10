package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @author zhengzp
 * 2019-12-10 17:29
 */
public class TwoSumK2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 4;
        System.out.println(subarraySum(nums, k));
    }

    /**
     * 计算方法
     *
     * sum[j] = sum[0] + sum[1] + ... + +sum[i] + ... + sum[j]
     * sum[i] = sum[0] + sum[1] + ... + sum[i]
     * sum[i:j] = sum[j] - sum[i]
     *
     * sum 单调递增， sum[j] - k 也是单调递增
     * sum[i:j] = sum[j] - sum[i] 带入 k 变形成为 sum[i:j] = sum[j] - sum[i], sum[i:j] = k, sum[j] - k = sum[i]
     * 判断 sum[i] 在 map 数量 加上即可
     *
     * @param nums 数组
     * @param k 目标值
     * @return int
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            // 检查是否存在 sum[i] + k == sum[j]
            int pSum = sum - k;
            if (map.containsKey(pSum)) {
                ans += map.get(pSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
