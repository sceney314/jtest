package leetcode.linkedlist;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值 -- 最优解动态规划
 * <p>
 * 2020-03-10 06:52
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1};
        int[] res = (new MaxSlidingWindow()).maxSlidingWindow(nums, 1);
        for (int k : res){
            System.out.printf("%d,", k);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1){
            return new int[0];
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length >= k ? nums.length - k + 1 : 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            // 确保队列里面最前面的在 k 个范围内，如果索引小于当前索引-k 则一定不再范围内
            if (i >= k && list.getFirst() < (i - k)){
                list.pollFirst();
            }

            // 如果当前元素比最后元素大，则弹出最后元素
            while (!list.isEmpty() &&  nums[list.getLast()] <= nums[i]){
                list.pollLast();
            }

            // 每次都添加 i
            list.addLast(i);

            // i 大于等于 k - 1，每次移动都需要判断输出一个元素
            if (i >= k -1){
                res[j++] = nums[list.getFirst()];
            }
        }

        return res;
    }
}
