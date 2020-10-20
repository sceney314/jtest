package leetcode.sortalgorithm;

/**
 * 希尔排序
 * <p>
 * 2020-03-17 07:08
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34, 5423, 23, 5, 634, 42, 63};
        shell(nums);
        for (int n : nums) {
            System.out.printf("%d ", n);
        }
    }

    public static void shell(int[] nums) {
        // 对数组进行分组, 直到 gap = 1分组完成，完成插入排序
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            // 对分组进行插入排序
            for (int k = gap; k < nums.length; k++) {
                int m = k;
                while (m - gap >= 0 && nums[m] < nums[m - gap]) {
                    int tmp = nums[m];
                    nums[m] = nums[m - gap];
                    nums[m - gap] = tmp;
                    m -= gap;
                }
            }
        }
    }
}
