package leetcode.tree;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 2020-06-28 11:29
 */
public class TreeToDoublyList {
    public static void main(String[] args) {
        TreeToDoublyList list = new TreeToDoublyList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        System.out.println(list.doublyList(n4));
    }

    private Node doublyList(Node root) {
        Node head = null, pre = null;
        Node[] nodes = dfs(root, head, pre);
        head = nodes[0];
        pre = nodes[1];
        pre.right = head;
        head.left = pre;
        return head;
    }

    private Node[] dfs(Node tree, Node head, Node pre){
        if(tree == null){
            return new Node[]{head, pre};
        }

        Node[] nodes = dfs(tree.left, head, pre);
        head = nodes[0];
        pre = nodes[1];


        if(head == null){
            head = tree;
            pre = tree;
        }else{
            // 设置后继节点
            pre.right = tree;
            // 设置前驱节点
            tree.left = pre;
            // 修改 pre
            pre = tree;
        }

        Node[] nodes2 = dfs(tree.right, head, pre);
        head = nodes2[0];
        pre = nodes2[1];
        return  new Node[]{head, pre};
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
