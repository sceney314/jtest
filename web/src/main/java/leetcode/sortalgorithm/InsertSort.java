package leetcode.sortalgorithm;

/**
 * 插入排序
 * <p>
 * 2020-03-17 07:05
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34,5423,23, 5,634,42,63};
        insertion(nums);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    public static void insertion(int[] nums){
        for (int i = 1; i < nums.length; i++){
            for (int k = i - 1, m = i; k >= 0; k--){
                if (nums[m] >= nums[k]){
                    break;
                }

                int tmp = nums[k];
                nums[k] = nums[m];
                nums[m] = tmp;
                m = k;
            }
        }
    }
}
