package leetcode.sortalgorithm;

/**
 * 归并排序
 * <p>
 * 2020-03-17 07:07
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34,5423,23, 5, 24, 23, 34,634,42,63};
        mergeSort(nums, 0, nums.length - 1);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    public static void mergeSort(int[] nums, int start, int end){
        if (start >= end){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int left, int mid, int right){
        int[] tmp = new int[nums.length];
        int p1 = left, p2 = mid + 1, k = left;

        // 合并数据
        while(p1 <= mid && p2 <= right){
            if(nums[p1] <= nums[p2]){
                tmp[k++] = nums[p1++];
            }
            else{
                tmp[k++] = nums[p2++];
            }
        }

        // 如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p1 <= mid){
            tmp[k++] = nums[p1++];
        }

        // 如果第二个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2 <= right){
            tmp[k++] = nums[p2++];
        }

        for (int i = left; i <=right; i++){
            nums[i]= tmp[i];
        }
    }
}
