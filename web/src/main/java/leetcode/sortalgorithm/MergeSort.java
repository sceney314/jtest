package leetcode.sortalgorithm;

/**
 * 归并排序
 * <p>
 * 2020-03-17 07:07
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{34,5423,23, 5, 24, 23, 34,634,42,63};
//        mergeSort(nums, 0, nums.length - 1);
        mergeSortDown2Up(nums);
        for (int n : nums){
            System.out.printf("%d ", n);
        }
    }

    /*
     * 对数组a做若干次合并：数组a的总长度为len，将它分为若干个长度为gap的子数组；
     *             将"每2个相邻的子数组" 进行合并排序。
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     len -- 数组的长度
     *     gap -- 子数组的长度
     */
    public static void mergeGroups(int[] a, int len, int gap) {
        int i;
        // 两个相邻的子数组的长度
        int twolen = 2 * gap;

        // 将"每2个相邻的子数组" 进行合并排序。
        for(i = 0; i+2*gap-1 < len; i+=(2*gap))
            merge(a, i, i+gap-1, i+2*gap-1);

        // 若 i+gap-1 < len-1，则剩余一个子数组没有配对。
        // 将该子数组合并到已排序的数组中。
        if ( i+gap-1 < len-1)
            merge(a, i, i + gap - 1, len - 1);
    }

    /*
     * 归并排序(从下往上)
     *
     * 参数说明：
     *     a -- 待排序的数组
     */
    public static void mergeSortDown2Up(int[] a) {
        if (a==null)
            return ;

        for(int n = 1; n < a.length; n*=2)
            mergeGroups(a, a.length, n);
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
