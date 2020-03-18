package leetcode.sortalgorithm;

/**
 * 快速排序
 * <p>
 * 2020-03-17 07:05
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34,5423,23, 5,34,634,42,63};
        quick(nums, 0, nums.length - 1);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    public static void quick(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start, right = end;
        while (left < right){
            while (nums[right] > pivot){
                right--;
            }

            while (nums[left] < pivot){
                left++;
            }

            if (left < right && nums[left] == nums[right]){
                left++;
                continue;
            }

            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }

        if (left - 1 > start){
            quick(nums, start, left - 1);
        }

        if (right + 1 < end){
            quick(nums, right + 1, end);
        }
    }
}
