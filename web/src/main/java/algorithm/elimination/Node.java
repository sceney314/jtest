package algorithm.elimination;

/**
 * 节点
 * <p>
 * 2020-04-17 19:49
 */
public class Node {
    public Node next;
    public Node prev;
    public int val;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}
