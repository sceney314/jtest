package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树
 * <p>
 * 2020-03-25 13:40
 */
public class BinarySearchTree{
    private Node root;

    /**
     * 添加节点
     *
     * @param elem 添加元素
     */
    public void add(int elem){

        Node n = new Node(elem);
        if (root == null){
            root = n;
            return;
        }

        Node tree = root;
        Node father = null;
        while (tree != null){
            father = tree;
            if (tree.val > n.val){
                tree = tree.left;
            }else if (tree.val < n.val){
                tree = tree.right;
            }else{
                return;
            }
        }

        n.parent = father;
        if (father.val > n.val){
            father.left = n;
        }else{
            father.right = n;
        }
    }


    private Node getNode(int elem){
        Node tree = root;
        while (tree != null){
            if (tree.val > elem){
                tree = tree.left;
            }else if (tree.val < elem){
                tree = tree.right;
            }else {
                return tree;
            }
        }

        return tree;
    }

    /**
     * 找结点(x)的前驱结点。即，查找"二叉树中数据值小于该结点"的"最大结点"。
     *
     * @param n 节点
     * @return Node
     */
    private Node predecessor(Node n){
        if (n == null){
            return null;
        }

        if (n.left != null){
            return maximum(n.left);
        }

        // n是"一个右孩子"，则"n的前驱结点"为 "它的父结点"。
        // n是"一个左孩子"，则查找" n 的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是" n 的前驱结点"。
        Node p = n.parent;
        while (p != null && p.left == n){
            n = p;
            p = p.parent;
        }

        return p;
    }

    /**
     * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
     *
     * @param n 节点
     * @return Node
     */
    private Node successor(Node n){
        if (n.right != null){
            return minimum(n.right);
        }

        // n 是左孩子则后继节点是父节点
        // n 是右孩子，则找到 n 最低父节点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是" n 的后继结点"。
        Node p = n.parent;
        while (p != null && p.right == n){
            n = p;
            p = p.parent;
        }

        return p;
    }

    /**
     * 获取树的最小节点
     *
     * @param tree 树
     * @return Node
     */
    private Node minimum(Node tree){
        if (tree == null){
            return null;
        }

        while (tree.left != null){
            tree = tree.left;
        }

        return tree;
    }

    /**
     * 获取树的最大节点
     *
     * @param tree 树
     * @return Node
     */
    private Node maximum(Node tree){
        if (tree == null){
            return null;
        }

        while (tree.right != null){
            tree = tree.right;
        }

        return tree;
    }

    /**
     * 元素是否存在
     *
     * @param data 目标元素
     * @return
     */
    public boolean contains(int data){
        Node target = getNode(data);
        return target != null;
    }

    /**
     * 删除节点
     * 删除节点右三种中情况
     * 1、节点是叶子节点，可以直接删除
     * 2、节点只有左（右）子树，可直接删除，将子节点的父节点设置为子节点的祖父节点
     * 3、节点有左右孩子，这个时候找后继节点，删除操作相当于将后继节点赋值给目标节点，
     *    然后删除后继节点，根据后继节点特性，后继节点要么是叶子节点，要么只有一个孩子。
     *
     * @param elem 需要删除元素
     */
    public void del(int elem){
        // 获取目标节点
        Node target = getNode(elem);
        if (target == null){
            return;
        }

        Node del = null, child = null;
        // 需要目标节点只有左子树或者右子树，或目标节点是叶子节点，则目标节点就是需要删除的节点
        if (target.left == null || target.right == null){
            del = target;
        }else{
            // 目标节点左右子树都存在则需要删除的是后继节点
            del = successor(target);
        }

        // 已经确定的删除节点，最多只有一个孩子，将删除节点的孩子赋值给 child
        if (del.left != null){
            child = del.left;
        } else{
            child = del.right;
        }

        // 如果确定删除节点的存在孩子，则调整孩子的父节点指向
        if (child != null){
            child.parent = del.parent;
        }

        // 如果删除节点的父节点是 null 则表示子节点是根，或者空树
        if (del.parent == null){
            root = child;
        } else if (del == del.parent.left){
            // 如果删除节点是父节点左孩子，将删除节点的子节点变为删除节点的父节点的左孩子
            del.parent.left = child;
        } else{
            // 如果删除节点是父节点右孩子，将删除节点的子节点变为删除节点的父节点的右孩子
            del.parent.right = child;
        }

        // del 这个节点已经删掉，如果 del 节点和 target 节点不一致表示是删除的后继节点，需要将后继节点的值复制给目标节点
        if (del != target){
            target.val = del.val;
        }
    }

    /**
     * 中序遍历，出来是有序数组
     *
     * @return List
     */
    public List<Integer> inOrder(){
        List<Integer> data = new ArrayList<>();
        if (root != null){
            orderSearch(root, data);
        }
        return data;
    }

    private void orderSearch(Node tree, List<Integer> data){
        if (tree == null){
            return;
        }
        orderSearch(tree.left, data);
        data.add(tree.val);
        orderSearch(tree.right, data);
    }


    private class Node{
        int val;
        Node left;
        Node right;
        Node parent;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
