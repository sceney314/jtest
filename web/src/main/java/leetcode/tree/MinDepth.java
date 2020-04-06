package leetcode.tree;


/**
 * 111. 二叉树的最小深度
 * <p>
 * 2020-04-06 18:15
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println((new MinDepth()).minDepth(node3));
    }
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null){
            return 1 + minDepth(root.right);
        }

        if (root.right == null){
            return 1 + minDepth(root.left);
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return 1 + Math.min(left, right);
    }
}
