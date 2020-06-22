package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * <p>
 * 2020-06-16 16:10
 */
public class MinSubsequence {
    public static void main(String[] args) {
        MinSubsequence subsequence = new MinSubsequence();
        int[] nums = new int[]{4,4,7,6,7};
        System.out.println(subsequence.minSubsequence2(nums));
        System.out.println(subsequence.minSubsequence(nums));
    }

    public List<Integer> minSubsequence(int[] nums) {
        int[] elems = new int[101];
        long sum = 0l, half = 0l, ansSum = 0l;
        List<Integer> ans = new ArrayList<>();
        for(int n : nums){
            elems[n] += 1;
            sum += n;
        }
        half = sum / 2;
        for(int i = elems.length - 1; i >= 0; i--){
            if(elems[i] == 0){
                continue;
            }
            int tmp = elems[i];
            while(tmp > 0){
                if(ansSum > half){
                    return ans;
                }
                ansSum += i;
                ans.add(i);
                tmp--;
            }
        }
        return ans;
    }

    public List<Integer> minSubsequence2(int[] nums) {
        quick(nums, 0, nums.length - 1);
        long ansSum = 0l, sum = 0;
        List<Integer> ans = new ArrayList<>();
        for(int n : nums){
            sum += n;
        }
        long half = sum / 2;
        for(int j = nums.length - 1; j >= 0; j--){
            if(ansSum > half){
                break;
            }
            ansSum += nums[j];
            ans.add(nums[j]);
        }

        return ans;
    }

    private void quick(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start, right = end;
        while(left < right){
            // nums[right] <= pivot
            while(nums[right] > pivot){
                right--;
            }

            // nums[left] >= pivot
            while(nums[left] < pivot){
                left++;
            }

            // 如果左边等于右边则表示 nums[left] == nums[right] == pivot
            if (left < right && nums[left] == nums[right]){
                left++;
                continue;
            }

            // 执行到这里，nums[left] > pivot;
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }

        // pivot 左边还有空间则继续排序
        if (left - 1 > start){
            quick(nums, start, left - 1);
        }

        // pivot 右边还有空间则继续排序
        if (right + 1 < end){
            quick(nums, right + 1, end);
        }
    }
}
