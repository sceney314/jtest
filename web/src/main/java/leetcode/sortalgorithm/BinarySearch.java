package leetcode.sortalgorithm;

/**
 * 二分查找
 * <p>
 * 2020-03-17 07:09
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 23, 34, 42, 63, 634, 5423};
        System.out.println(binary(nums, 54231));
    }

    public static int binary(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right){
            if (nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
            mid = (left + right) / 2;
        }

        return -1;
    }
}
