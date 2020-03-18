package leetcode.sortalgorithm;

/**
 * 堆排序 参照最大(小)堆
 * <p>
 * 2020-03-17 07:08
 */
public class HeapSort {
    private int[] heap;
    private int size = 0;

    public HeapSort() {
        heap = new int[8];
    }


    private void grow(int minSize) {
        if (heap.length > minSize) {
            return;
        }

        int newSize = heap.length + heap.length << 1;
        if (Integer.MAX_VALUE - 8 < newSize) {
            newSize = Integer.MAX_VALUE - 8;
        }

        int[] newHeap = new int[newSize];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }

        heap = newHeap;
    }

    public HeapSort(int[] nums) {
        heap = nums;
        size = nums.length;
        heapify();
    }

    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--) {
            heapify(i, heap[i]);
        }
    }

    private void heapify(int i, int data) {
        // 总最后一个叶子节点的父节点开始排序
        int half = size >>> 1;
        while (i < half) {
            // 左子结点：2i（2i ≤ n）， 若不满足则无左子结点。
            int child = (i << 1) + 1;
            // 右子结点：2i + 1(2i + 1 ≤ n)
            int right = child + 1;
            if (right < size && heap[child] < heap[right]) {
                child = right;
            }
            if (data > heap[child]) {
                break;
            }

            heap[i] = heap[child];
            i = child;
        }
        heap[i] = data;
    }

    public void add(int data) {
        grow(size + 1);
        int i = size;
        size = i + 1;
        if (i == 0) {
            heap[0] = data;
        } else {
            // 判断是否需要调整
            add(i, data);
        }
    }

    private void add(int i, int data) {
        while (i > 0) {
            // 父结点为：(i - 1) / 2（i ≠ 1），若i = 1，则i是根节点。
            int father = (i - 1) >>> 1;

            // 因为是最大堆，所以父节点大于等于子节点即可保证
            if (heap[father] >= data) {
                break;
            }
            heap[i] = heap[father];
            i = father;
        }

        heap[i] = data;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int delete() throws Exception {
        if (size == 0) {
            throw new Exception("堆空了");
        }

        int data = heap[0];
        int lastIndex = --size;
        int last = heap[lastIndex];
        heap[lastIndex] = 0;

        heapify(0, last);
        return data;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34, 5423, 23, 5, 634, 42, 63};
        HeapSort heap = new HeapSort(nums);
        try {
            while (!heap.isEmpty()) {
                System.out.printf("%d ", heap.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
