package leetcode.stack;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 用队列实现栈
 * <p>
 * 2020-03-06 05:34
 */
public class MyStack {
    private LinkedBlockingDeque<Integer> elementData;

    public MyStack() {
        this.elementData = new LinkedBlockingDeque<>();
    }

    public void push(int x) {
        elementData.addFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (elementData.peek() == null){
            return 0;
        }
        return elementData.poll();
    }

    /** Get the top element. */
    public int top() {
        return elementData.peek() == null ? 0 : elementData.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return elementData.isEmpty();
    }
}
