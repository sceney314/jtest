package leetcode.sortalgorithm;

/**
 * 选择排序
 * <p>
 * 2020-03-17 07:06
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34,5423,23, 5,634,42,63};
        selection(nums);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    public static void selection(int[] nums){
        for (int i = 0, min = i; i < nums.length; i++, min = i){
            for (int k = i + 1; k < nums.length; k++){
                if (nums[min] <= nums[k]){
                    continue;
                }
                min = k;
            }

            if (min == i){
                continue;
            }

            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }
}
