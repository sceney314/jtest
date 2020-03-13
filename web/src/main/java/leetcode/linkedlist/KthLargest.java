package leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第K大元素
 * <p>
 * 2020-03-11 06:19
 */
public class KthLargest {
    final PriorityQueue<Integer> queue;

    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(queue.size() < k){
            queue.offer(val);
        }else if(queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
    }
}
