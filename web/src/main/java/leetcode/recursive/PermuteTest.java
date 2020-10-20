package leetcode.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 2020-03-27 06:11
 */
public class PermuteTest {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        perm(nums, 0, nums.length - 1, res);
        return res;
    }

    private void perm(int[] nums, int start, int end, List<List<Integer>> res) {
        if (start == end) {
            List<Integer> son = new ArrayList<>();
            for (int i = 0; i <= end; i++) {
                son.add(nums[i]);
            }
            res.add(son);
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            perm(nums, start + 1, end, res);
            swap(nums, start, i);
        }
    }

    private void swap(int nums[], int k, int m) {
        int temp = nums[k];
        nums[k] = nums[m];
        nums[m] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println((new PermuteTest()).permute(nums));
    }


}
