package leetcode.linkedlist;

import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * <p>
 * 2020-03-10 06:52
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = (new MaxSlidingWindow()).maxSlidingWindow(nums, 3);
        for (int k : res){
            System.out.printf("%n,", k);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - 2];
        if (k >= nums.length){
            int max = 0;
            for (int n : nums){
                max = max > n ? max : n;
            }

            return new int[]{max};
        }


        LinkedList<Integer> list = new LinkedList<>();
        for (int i = k - 1; i < nums.length; i++){
            int max = result[i-1];
        }

        return result;
    }
}
