package algorithm.binarytree;


import java.util.ArrayList;
import java.util.List;

/**
 * 高度平衡的而二叉树（AVL 树）
 * <p>
 * 2020-03-25 16:19
 */
public class AVLTree {
    // 树的根
    private TreeNode root;

    /**
     * 获取树的高度
     *
     * @return int
     */
    private int height() {
        return root.height;
    }

    /**
     * 获取节点高度
     *
     * @param node 节点
     * @return int
     */
    private int height(TreeNode node) {
        return node == null ? 0 : node.height;
    }

    /**
     * 右旋
     *
     * @param node 进行右旋的节点
     * @return TreeNode
     */
    private TreeNode rotateRight(TreeNode node) {
        TreeNode lchild = node.left;
        node.left = lchild.right;
        lchild.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        lchild.height = Math.max(height(lchild.left), node.height) + 1;
        return lchild;
    }

    /**
     * 左旋
     *
     * @param node 进行左旋的节点
     * @return TreeNode
     */
    private TreeNode rotateLeft(TreeNode node) {
        TreeNode rchild = node.right;
        node.right = rchild.left;
        rchild.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rchild.height = Math.max(height(rchild.right), node.height) + 1;

        return rchild;
    }

    /**
     * 右左失衡，先进行一次右旋，再左旋，恢复平衡
     *
     * @param node 需要旋转的节点
     * @return TreeNode
     */
    private TreeNode rotateRightLeft(TreeNode node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    /**
     * 左右失衡，先进行一次左旋，再右旋，恢复平衡
     *
     * @param node 需要旋转的节点
     * @return TreeNode
     */
    private TreeNode rotateLeftRight(TreeNode node) {
        node.left = rotateLeft(node.left);

        return rotateRight(node);
    }

    /**
     * 节点中搜索数据元素节点
     *
     * @param data 数据
     * @return TreeNode
     */
    private TreeNode nodeSearch(int data) {
        return nodeSearch(root, data);
    }

    /**
     * 节点中搜索数据元素节点
     *
     * @param node 树
     * @param data 数据
     * @return TreeNode
     */
    private TreeNode nodeSearch(TreeNode node, int data) {
        if (node == null) {
            return null;
        }

        while (node != null) {
            if (node.val > data) {
                node = node.left;
            } else if (node.val < data) {
                node = node.right;
            } else {
                return node;
            }
        }

        return node;
    }

    /**
     * 删除元素
     *
     * @param data 元素值
     */
    public void del(int data) {
        TreeNode node = nodeSearch(data);
        if (node == null) {
            return;
        }

        root = remove(root, node);
    }

    /**
     * 删除元素
     *
     * @param tree 树
     * @param node 需要被删除的节点
     * @return TreeNode
     */
    private TreeNode remove(TreeNode tree, TreeNode node) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree == null || node == null) {
            return null;
        }

        if (tree.val > node.val) {
            // 删除在左子树
            tree.left = remove(tree.left, node);
            // 删除之后引起树失衡,树的右边高
            if (Math.abs(height(tree.left) - height(tree.right)) > 1){
                TreeNode rchild = tree.right;
                if (height(rchild.left) > height(rchild.right)){
                    // 右左失衡
                    tree = rotateRightLeft(tree);
                }else{
                    // 右右失衡
                    tree = rotateLeft(tree);
                }
            }
        } else if (tree.val < node.val) {
            // 删除在右子树
            tree.right = remove(tree.right, node);
            if (Math.abs(height(tree.left) - height(tree.right)) > 1){
                TreeNode lchild = tree.left;
                if (height(lchild.left) > height(lchild.right)){
                    // 左左失衡
                    tree = rotateRightLeft(tree);
                }else{
                    // 左右失衡
                    tree = rotateLeftRight(tree);
                }
            }
        } else {
            if (tree.left != null && tree.right != null) {
                // 左子树高于右子树
                if (height(tree.left) > height(tree.left)){
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    TreeNode max = maximum(tree.left);
                    tree.val = max.val;
                    tree.left = remove(tree.left, max);
                }else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    TreeNode min = minimum(tree.right);
                    tree.val = min.val;
                    tree.right = remove(tree.right, min);
                }
            } else {
                TreeNode tmp = tree;
                tree = (tree.left != null) ? tree.left : tree.right;
                // 销毁被删除元素
                tmp = null;
            }
        }

        return tree;
    }

    /**
     * 获取最大节点
     *
     * @return TreeNode
     */
    private TreeNode maximun() {
        return maximum(root);
    }

    /**
     * 获取最大节点
     *
     * @return TreeNode
     */
    private TreeNode maximum(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    /**
     * 获取最小节点
     *
     * @return TreeNode
     */
    private TreeNode minimum() {
        return minimum(root);
    }

    /**
     * 获取最小节点
     *
     * @return TreeNode
     */
    private TreeNode minimum(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }


    /**
     * 添加元素
     *
     * @param data 元素
     */
    public void add(int data) {
        try {
            root = add(root, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入节点
     *
     * @param tree 树
     * @param data 添加元素
     * @return TreeNode
     */
    private TreeNode add(TreeNode tree, int data) throws Exception {
//        TreeNode leaf = new TreeNode(data, 1);
        if (tree == null) {
            tree = new TreeNode(data, 1);
            return tree;
        }

        if (tree.val > data) {
            // 添加到左子树
            tree.left = add(tree.left, data);
            // 插入节点后，若AVL树失去平衡，则进行相应的调节。
            if (Math.abs(height(tree.left) - height(tree.right)) > 1) {
                if (data > tree.left.val) {
                    // 添加到右子树, 左右失衡
                    tree = rotateLeftRight(tree);
                } else {
                    // 添加到左子树, 左左失衡
                    tree = rotateRight(tree);
                }
            }
        } else if (tree.val < data) {
            // 添加到右子树
            tree.right = add(tree.right, data);
            // 左右子树相差大于 1 失衡
            if (Math.abs(height(tree.left) - height(tree.right)) > 1) {
                if (data > tree.right.val) {
                    // 右右失衡
                    tree = rotateLeft(tree);
                } else {
                    // 右左左失衡
                    tree = rotateRightLeft(tree);
                }
            }
        } else {
            throw new Exception("不能添加下同节点！");
        }

        tree.height = Math.max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    public List<Integer> inOrder() {
        List<Integer> data = new ArrayList<>();
        if (root != null) {
            orderSearch(root, data);
        }
        return data;
    }

    private void orderSearch(TreeNode tree, List<Integer> data) {
        if (tree == null) {
            return;
        }
        orderSearch(tree.left, data);
        data.add(tree.val);
        orderSearch(tree.right, data);
    }


    /**
     * AVL 树节点定义
     */
    private class TreeNode {
        // 左孩子
        TreeNode left;

        // 右孩子
        TreeNode right;

        // 节点值
        int val;

        // 高度
        int height;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, int height) {
            this.val = val;
            this.height = height;
        }
    }
}
