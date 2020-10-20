package test;

import java.util.regex.Pattern;

/**
 * @author zhengzp
 * 2019-08-05 16:09
 */
public class Test {

    public static void main(String[] args) {
        String con = "0.2";
        String reg = "^\\d+|\\d+\\.\\d{1,2}$";
        System.out.println(Pattern.matches(reg, con));
        System.out.println((int)'0');
        System.out.println((int)'9' - (int)'0');
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