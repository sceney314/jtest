package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * <p>
 * 2020-04-06 17:51
 */
public class LevelOrderTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addFirst(root);
        while (!nodes.isEmpty()){
            List<Integer> levels = new ArrayList<>();
            int count = nodes.size();
            while (count-- > 0){
                TreeNode node = nodes.pollFirst();
                levels.add(node.val);
                if (node.left != null){
                    nodes.addLast(node.left);
                }
                if (node.right != null){
                    nodes.addLast(node.right);
                }
            }
            res.add(levels);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 0);
    }
}
