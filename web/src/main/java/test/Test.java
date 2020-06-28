package test;

/**
 * @author zhengzp
 * 2019-08-05 16:09
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        quicSort(nums, 0, nums.length - 1);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    private static void quicSort(int[] nums, int start, int end) {
        int privote = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (nums[left] < privote) {
                left++;
            }

            while (nums[right] > privote) {
                right--;
            }

            if (left < right && nums[left] == nums[right]) {
                left++;
                continue;
            }

            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }

        if ((left - 1) > start) {
            quicSort(nums, start, left - 1);
        }

        if ((right + 1) < end) {
            quicSort(nums, right + 1, end);
        }
    }


}