package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 2020-03-25 06:13
 */
public class LowestCommonAncestor {
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

        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        System.out.println(ancestor.lowestCommonAncestor(n6, n2, n8));
        System.out.println(ancestor.lowestCommonAncestor2(n6, n2, n8));
        System.out.println(ancestor.lowestCommonAncestor3(n6, n2, n8));

    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> plist = findNode(root, p);
        List<TreeNode> qlist = findNode(root, q);
        int n = qlist.size() > plist.size() ? plist.size() : qlist.size();
        TreeNode father = null;
        for (int i = 0; i < n; i++) {
            if (qlist.get(i) == plist.get(i)) {
                continue;
            }
            father = qlist.get(--i);
            break;
        }

        if (father == null) {
            father = qlist.get(--n);
        }

        return father;
    }

    public List<TreeNode> findNode(TreeNode root, TreeNode t) {
        List<TreeNode> res = new ArrayList<>();
        while (root != null) {
            res.add(root);
            if (root.val > t.val) {
                root = root.left;
            } else if (root.val < t.val) {
                root = root.right;
            } else {
                return res;
            }
        }

        return res;
    }
}
