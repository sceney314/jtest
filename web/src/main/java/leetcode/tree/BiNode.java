package leetcode.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 2020-05-26 10:45
 */
public class BiNode {

    @Data
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        String[] line = new String[8];
        Arrays.fill(line, ".");
        line[6] = "Q";
        List<String> row = Arrays.asList(line);
        System.out.println(Arrays.toString(line));

        BiNode bn = new BiNode();
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n0 = new TreeNode(0);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        n5.right = n6;
        n1.left = n0;


        System.out.println(bn.convertBiNode(n4));
    }

    public TreeNode convertBiNode(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode node = new TreeNode(0);
        TreeNode head = node;
        btree(root, node);
        return head.right;
    }

    private TreeNode btree(TreeNode tree, TreeNode node){
        if(tree == null){
            return node;
        }
        node = btree(tree.left, node);
        node.right = new TreeNode(tree.val);
        node = node.right;
        node = btree(tree.right, node);
        return  node;
    }
}
