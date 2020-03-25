package leetcode.tree;

/**
 * 98.验证搜索二叉树
 * <p>
 * 2020-03-24 20:24
 */
public class ValidBST {
    private TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isValidBST(root.left)) {
            return false;
        }

        if(max == null || root.val > max.val) {
            max = root;
        } else {
            return false;
        }

        if(!isValidBST(root.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n2.left = n1;
        n1.right = n4;
        n4.left = n3;
        ValidBST bst = new ValidBST();
        System.out.println(bst.isValidBST(n1));
    }
}
