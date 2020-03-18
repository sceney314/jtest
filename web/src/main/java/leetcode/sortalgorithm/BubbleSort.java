package leetcode.sortalgorithm;

/**
 * 冒泡排序
 * <p>
 * 2020-03-17 07:06
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34,5423,23, 5,634,42,63};
        bubble(nums);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    public static void bubble(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] <= nums[j]){
                    continue;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
