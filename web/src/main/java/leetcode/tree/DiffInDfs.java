package leetcode.tree;

import java.util.ArrayList;

/**
 * 2020-05-20 17:16
 */
public class DiffInDfs {
    public static void main(String[] args) {
        TreeNode node27 = new TreeNode(27);
        TreeNode node34 = new TreeNode(34);
        TreeNode node44 = new TreeNode(44);
        TreeNode node50 = new TreeNode(50);
        TreeNode node58 = new TreeNode(58);
        node27.right = node34;
        node34.right = node58;
        node58.left = node50;
        node50.left = node44;
        DiffInDfs dfs = new DiffInDfs();
        System.out.println(dfs.minDiffInBST(node27));
    }

    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> data = new ArrayList<>();
        middle(root, data);
        int min = data.get(1) - data.get(0);
        for(int i = 1, j = i + 1; j < data.size(); j++, i++){
            int tmp = data.get(j) - data.get(i);
            if(min > tmp){
                min = tmp;
            }
        }

        return min;
    }

    public void middle(TreeNode tree, ArrayList<Integer> data){
        if(tree == null){
            return;
        }
        middle(tree.left, data);
        data.add(tree.val);
        middle(tree.right, data);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
