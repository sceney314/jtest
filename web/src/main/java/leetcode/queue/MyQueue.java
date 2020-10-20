package leetcode.queue;

import java.util.Stack;

/**
 * 用栈实现队列
 * <p>
 * 2020-03-06 05:53
 */
public class MyQueue {
    private Stack<Integer> queue;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.queue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.remove(0);
    }

    /** Get the front element. */
    public int peek() {
        return queue.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
