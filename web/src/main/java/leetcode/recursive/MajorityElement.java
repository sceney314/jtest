package leetcode.recursive;

/**
 * 169. 多数元素
 * <p>
 * 2020-04-03 07:08
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        return majority(nums, 0, nums.length - 1);
    }

    private int majority(int[] nums, int start, int end){
        if (start == end){
            return nums[start];
        }

        int mid = (start + end) / 2;
        int left = majority(nums, start, mid);
        int right = majority(nums, mid + 1, end);
        if (left == right){
            return left;
        }

        int leftCount = majorityCount(nums, left, start, mid);
        int rightCount = majorityCount(nums, right, mid + 1, end);
        return leftCount > rightCount ? left : right;
    }

    public int majorityCount(int[] nums, int num, int start, int end){
        int count = 0;
        while (start <= end){
            if (nums[start] == num){
                count++;
            }
            start++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] d = new int[]{2,2,1,1,1,2,2};
        System.out.println((new MajorityElement()).majorityElement(d));
    }
}
