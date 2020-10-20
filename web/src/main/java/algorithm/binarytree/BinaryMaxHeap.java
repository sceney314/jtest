package algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉堆 - 最大堆
 * <p>
 * 2020-04-01 15:19
 */
public class BinaryMaxHeap<T extends Comparable<T>> {
    private List<T> heap;

    public BinaryMaxHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * 粗堆里面删除元素
     * JDK 里面只能删除根节点
     *
     * @param data 元素值。
     */
    public void remove(T data) {
        if (heap.isEmpty()) {
            return;
        }

        int index = heap.indexOf(data);
        if (index == -1) {
            return;
        }

        int size = heap.size();
        heap.set(index, heap.get(size - 1));
        heap.remove(size - 1);
        if (heap.size() > 1) {
            filterdown(index, heap.size() - 1);
        }
    }

    /**
     * 向下调整
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *
     * @param start 被下调节点的起始位置(一般为0，表示从第1个开始)
     * @param end   截至范围(一般为数组中最后一个元素的索引)
     */
    private void filterdown(int start, int end) {
        // 当前(current)节点的位置
        int c = start;
        // 左(left)孩子的位置
        int l = 2 * c + 1;
        // 当前(current)节点的大小
        T tmp = heap.get(c);
        while (l <= end) {
            // "l"是左孩子，"l+1"是右孩子
            int cmp = heap.get(l).compareTo(heap.get(l + 1));

            // 左右两孩子中选择较大者，即mHeap[l+1]
            if (l < end && cmp < 0) {
                l++;
            }

            cmp = tmp.compareTo(heap.get(l));
            if (cmp >= 0) {
                break;
            } else {
                heap.set(c, heap.get(l));
                c = l;
                l = 2 * l + 1;
            }
        }
        heap.set(c, tmp);
    }

    /**
     * 添加元素
     *
     * @param data 添加元素
     */
    public void insert(T data) {
        if (data == null) {
            return;
        }
        int size = heap.size();
        heap.add(data);
        filterUp(size);
    }

    /**
     * 向上调整
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *
     * @param k 插入索引位置
     */
    private void filterUp(int k) {
        int c = k;
        int parent = (k - 1) / 2;
        T data = heap.get(c);
        while (c > 0) {
            int cmp = heap.get(parent).compareTo(data);
            if (cmp >= 0) {
                break;
            } else {
                heap.set(c, heap.get(parent));
                c = parent;
                parent = (c - 1) / 2;
            }
        }

        heap.set(c, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heap.size(); i++)
            sb.append(heap.get(i) + " ");

        return sb.toString();
    }

    public static void main(String[] args) {
        int i;
        int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
        BinaryMaxHeap<Integer> tree = new BinaryMaxHeap<>();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
            tree.insert(a[i]);
        }

        System.out.printf("\n== 最 大 堆: %s", tree);

        i = 85;
        tree.insert(i);
        System.out.printf("\n== 添加元素: %d", i);
        System.out.printf("\n== 最 大 堆: %s", tree);

        i = 90;
        tree.remove(i);
        System.out.printf("\n== 删除元素: %d", i);
        System.out.printf("\n== 最 大 堆: %s", tree);
        System.out.printf("\n");
    }

}
