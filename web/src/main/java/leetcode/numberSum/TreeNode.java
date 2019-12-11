package leetcode.numberSum;

import lombok.Data;

/**
 * 节点
 *
 * @author zhengzp
 * 2019-12-10 15:42
 */
@Data
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}
