package test;

/**
 * 2020-07-03 15:46
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 0, 1, 2, 4, 12, 8, 3, 5, 6, 7};
        sort(nums, 0, nums.length - 1);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int m = start, n = mid + 1, k = start;
        int[] tmp = new int[nums.length];
        while (m <= mid && n <= end){
            if(nums[m] < nums[n]){
                tmp[k++] = nums[m++];
            }else{
                tmp[k++] = nums[n++];
            }
        }

        while (m <= mid){
            tmp[k++] = nums[m++];
        }

        while (n <= end){
            tmp[k++] = nums[n++];
        }

        for (int i = start; i <= end; i++){
            nums[i]= tmp[i];
        }
    }

}
