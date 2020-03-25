package leetcode.tree;

/**
 * 236. 二叉树的最近公共祖先
 * <p>
 * 2020-03-25 06:30
 */
public class LowestCommonAncestor2 {

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n6.left = n2;
        n6.right = n8;
        n8.left = n7;
        n8.right = n9;
        n2.left = n0;
        n2.right = n4;
        n4.left = n3;
        n4.right = n5;

        LowestCommonAncestor2 ancestor = new LowestCommonAncestor2();
        System.out.println(ancestor.lowestCommonAncestor(n6, n2, n4));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}
