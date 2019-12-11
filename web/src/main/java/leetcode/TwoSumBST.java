package leetcode;

import java.util.*;

/**
 * 两数之和 IV - 输入 BST
 *
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * @author zhengzp
 * 2019-12-10 15:38
 */
public class TwoSumBST {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        tree.setLeft(node3);
        tree.setRight(node6);
        node6.setRight(node7);
        node3.setLeft(node2);
        node3.setRight(node4);

        System.out.println(findTarget(tree, 9));
        System.out.println(findTarget(tree, 28));
    }

    public static boolean findTarget(TreeNode tree, int target){
        // 二叉搜索树，做孩子一定比根节点小，右节点一定比根节点大
        Map<Integer, Integer> numMap = new HashMap<>();

        Stack<TreeNode> nodeStack = new Stack<>();
        while (tree != null || !nodeStack.isEmpty()){
            while (tree != null){
                nodeStack.push(tree);
                tree = tree.getLeft();
            }

            TreeNode node = nodeStack.pop();
            int next = target - node.getVal();
            if (numMap.containsKey(next)){
                return true;
            }
            numMap.put(node.getVal(), node.getVal());
            tree = node.getRight();
        }

        return false;
    }



}